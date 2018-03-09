package com.pandawork.home.common.util;

import com.pandawork.core.pweio.excel.DataType;
import com.pandawork.core.pweio.excel.ExcelWriter;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.mail.internet.MimeUtility;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by root on 14-9-26.
 */
public final class ExcelUtil {
    public static Map<String,String> exportFieldDesc = new HashMap<>();
    static{
        //学籍信息
        exportFieldDesc.put("year","年度考核年份");
        exportFieldDesc.put("department","部门");
        exportFieldDesc.put("username","姓名");
        exportFieldDesc.put("realName","真实姓名");
        exportFieldDesc.put("role","角色");
        exportFieldDesc.put("month1","一月得分");
        exportFieldDesc.put("month2","二月得分");
        exportFieldDesc.put("month3","三月得分");
        exportFieldDesc.put("month4","四月得分");
        exportFieldDesc.put("month5","五月得分");
        exportFieldDesc.put("month6","六月得分");
        exportFieldDesc.put("month7","七月得分");
        exportFieldDesc.put("month8","八月得分");
        exportFieldDesc.put("month9","九月得分");
        exportFieldDesc.put("month10","十月得分");
        exportFieldDesc.put("month11","十一月得分");
        exportFieldDesc.put("month12","十二月得分");
        exportFieldDesc.put("queater1","第一季度得分");
        exportFieldDesc.put("queater2","第二季度得分");
        exportFieldDesc.put("queater3","第三季度得分");
        exportFieldDesc.put("queater4","第四季度得分");
        exportFieldDesc.put("summaryScore","年度总结得分");
        exportFieldDesc.put("abilityScore","年度能指标得分");
        exportFieldDesc.put("yearScore","年度绩效得分");
    }

    /**
     * 调用core导入Excel
     *
     * @param clazz 具体类
     * @param saveFileName 导入后Excel名称
     * @param beginRow 从第几行导入
     * @return list 返回对应Excel的list
     * SSException
     */
    public static List readExcel(HttpServletRequest request, Class clazz,String saveFileName,int beginRow){
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("file");
        File file=new File(request.getSession().getServletContext().getRealPath("/resources/upload") + "/"+saveFileName) ;
        try{
            FileUtils.writeByteArrayToFile(file, multipartFile.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        Field[] fields = clazz.getDeclaredFields();
        DataType[] dataTypes = new DataType[fields.length-1];
        for (int j = 1; j < fields.length; j++) {
            if(!fields[j].isAccessible()){
                fields[j].setAccessible(true);
            }
            DataType dataType = new DataType(fields[j].getName(),j-1);
            dataTypes[j-1] = dataType;
        }
        List list0 = null;
        try {
            Class c = Class.forName("com.pandawork.core.excel.ExcelReader");
            Class[] args1 = new Class[4];
            args1[0] = Class.class;
            args1[1] = Sheet.class;
            args1[2] = int.class;
            args1[3] =dataTypes.getClass();
            Method m = c.getDeclaredMethod("readShell",args1);
            m.setAccessible(true);
            Workbook book  =  Workbook.getWorkbook(file);
            Sheet sheet = book.getSheet(0);

            list0 = (List) m.invoke(c.newInstance(), clazz, sheet, beginRow, dataTypes);
            for(int i=0;i<list0.size();i++){
                if(i==(list0.size()-1)){
                    list0.remove(i);
                }
            }
            System.out.println(list0);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  list0;
    }

    /**
     * 调用core导出Excel
     *
     * @param list   要导出的数据集合
     * @param sheetName    Excel的sheet名称
     * @param path         导出Excel名称
     * SSException
     */
    public static void writeExcel(List list, String sheetName, String path, HttpServletResponse response){
        Field[] fields = list.get(0).getClass().getDeclaredFields();
        DataType[] dataTypes = new DataType[fields.length-1];
        DataType[] heads = new DataType[fields.length-1];
        for (int j = 1; j < fields.length; j++) {
            if(!fields[j].isAccessible()){
                fields[j].setAccessible(true);
            }
            DataType dataType = new DataType(fields[j].getName(),j-1);
            dataTypes[j-1] = dataType;
            heads[j-1] = new DataType(exportFieldDesc.get(fields[j].getName()),j-1);
        }
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-disposition", "attachment;filename=" + path);
        OutputStream out = null;
        try {
            out = response.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //out = new FileOutputStream(path);
            ExcelWriter.writeExcel(list,sheetName,out,heads,dataTypes);
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (Exception e) {
            e.printStackTrace();
         }
    }
    /**
     * 调用core导出Excel
     *
     * @param o   要导出的数据集合
     * @param sheetName    Excel的sheet名称
     * @param path         导出Excel名称
     * SSException
     */
    public static void writeExcel1(Object o, String sheetName, String path, HttpServletResponse response){

    }
    public static String encodeFilename(String filename, HttpServletRequest request) {
        String agent = request.getHeader("USER-AGENT");
        try {
            if ((agent != null) && (-1 != agent.indexOf("MSIE"))) {
                String newFileName = URLEncoder.encode(filename, "UTF-8");
                newFileName = StringUtils.replace(newFileName, "+", "%20");
                if (newFileName.length() > 150) {
                    newFileName = new String(filename.getBytes("GB2312"), "ISO8859-1");
                    newFileName = StringUtils.replace(newFileName, " ", "%20");
                }
                return newFileName;
            }
            if ((agent != null) && (-1 != agent.indexOf("Mozilla")))
                return MimeUtility.encodeText(filename, "UTF-8", "B");

            return filename;
        } catch (Exception ex) {
            return filename;
        }
    }



}
