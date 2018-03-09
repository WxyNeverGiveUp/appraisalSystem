package com.pandawork.home.web.controller;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.dto.AllotDto;
import com.pandawork.home.common.dto.YearMonthExportDto;
import com.pandawork.home.common.dto.YearQueaterExportDto;
import com.pandawork.home.common.util.ExcelUtil;
import com.pandawork.home.service.check.TestPlanService;
import com.pandawork.home.service.query.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * ExportController
 *
 * @author typ
 * @date 2017/9/18 12:46
 */

@Controller
@RequestMapping(value = "/export")
public class ExportController extends AbstractController {

    @Autowired
    ExportService exportService;
    @Autowired
    TestPlanService testPlanService;
    /**
     * 导出年度月度绩效考核的成绩
     * @throws SSException
     */
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public void exportAllUser(HttpServletRequest request, HttpServletResponse response)throws SSException{
        try {
            List<AllotDto> list = testPlanService.listAllUser();

            String filename = "公司成员信息.xls";//设置下载时Excel的名称
            filename = ExcelUtil.encodeFilename(filename, request);//处理中文文件名
            ExcelUtil.writeExcel(list, "recruit", filename, response);//调用Excel工具类生成Excel
        }catch (SSException e){
            e.printStackTrace();
            LogClerk.errLog.error(e);
        }
    }
    /**
     * 导出年度月度绩效考核的成绩
     * @throws SSException
     */
    @RequestMapping(value = "/month",method = RequestMethod.GET)
    public void exportYearMonth(HttpServletRequest request, HttpServletResponse response)throws SSException{
        try {
            List<YearMonthExportDto> listMonth = exportService.exportYearMonth();

            String filename = "年度月度考核.xls";//设置下载时Excel的名称
            filename = ExcelUtil.encodeFilename(filename, request);//处理中文文件名
            ExcelUtil.writeExcel(listMonth, "recruit", filename, response);//调用Excel工具类生成Excel
        }catch (SSException e){
            e.printStackTrace();
            LogClerk.errLog.error(e);
        }
    }

    /**
     * 导出年度月度绩效考核的某一条成绩
     * @param
     * @param response
     * @param request
     */
    @RequestMapping(value = "/month/query",method = RequestMethod.GET)
    public void exportYearMonthByConditions( HttpServletResponse response, HttpServletRequest request, HttpSession session){
        try {
            int did;
//            System.out.println((int) session.getAttribute("queryMonthDid")+"哈哈哈");
            if (Assert.isNull((int) session.getAttribute("queryMonthDid"))){
                did = -1;
            }else {
                did = (int) session.getAttribute("queryMonthDid");
            }
            int rid ;
            if (Assert.isNull((int) session.getAttribute("queryMonthRid"))){
                rid = -1;
            }else {
                rid = (int) session.getAttribute("queryMonthRid");
            }
            int year;
            if (Assert.isNull((int) session.getAttribute("queryMonthYear"))){
                year=-1;
            }else {
                year =(int) session.getAttribute("queryMonthYear");
            }
            String username;
            if (Assert.isNull((String) session.getAttribute("queryMonthUName"))){
                username = "";
            }else {
                username  = (String) session.getAttribute("queryMonthUName");
            }
            List<YearMonthExportDto> listMonth = exportService.exportYearMonthByConditions(did, rid, year, username);

            String filename = "年度月度考核.xls";//设置下载时Excel的名称
            filename = ExcelUtil.encodeFilename(filename, request);//处理中文文件名
            ExcelUtil.writeExcel(listMonth, "recruit", filename, response);//调用Excel工具类生成Excel
        } catch (SSException e) {
            e.printStackTrace();
            LogClerk.errLog.error(e);
        }
    }

    /**
     * 根据部门ID查询年度月度考核
     * @param did
     * @param response
     * @param request
     * @throws Exception
     */
    @RequestMapping(value = "/month/query/did/{did}")
    public void exportYearMonthByDid(@PathVariable("did") int did,HttpServletResponse response, HttpServletRequest request)throws Exception{
        try {
            List<YearMonthExportDto> listMonth = exportService.queryMonthByDid(did);

            String filename = "年度月度考核.xls";//设置下载时Excel的名称
            filename = ExcelUtil.encodeFilename(filename, request);//处理中文文件名
            ExcelUtil.writeExcel(listMonth, "recruit", filename, response);//调用Excel工具类生成Excel
        } catch (SSException e) {
            e.printStackTrace();
            LogClerk.errLog.error(e);
        }
    }

    /**
     * 根据部门ID查询年度月度考核
     * @param uid
     * @param response
     * @param request
     * @throws Exception
     */
    @RequestMapping(value = "/month/query/uid/{uid}")
    public void exportYearMonthByUid(@PathVariable("uid") int uid,HttpServletResponse response, HttpServletRequest request)throws Exception{
        try {
            List<YearMonthExportDto> listMonth = exportService.queryMonthByUid(uid);

            String filename = "年度月度考核.xls";//设置下载时Excel的名称
            filename = ExcelUtil.encodeFilename(filename, request);//处理中文文件名
            ExcelUtil.writeExcel(listMonth, "recruit", filename, response);//调用Excel工具类生成Excel
        } catch (SSException e) {
            e.printStackTrace();
            LogClerk.errLog.error(e);
        }
    }

    /**
     * 导出所有的年度季度考核的成绩
     * @param request
     * @param response
     */
    @RequestMapping(value = "/quarter",method = RequestMethod.GET)
    public void exportYearQueater(HttpServletRequest request,HttpServletResponse response){
        try {
            List<YearQueaterExportDto> list = exportService.exportYearQueater();
            String filename = "年度季度考核.xls";//设置下载时Excel的名称
            filename = ExcelUtil.encodeFilename(filename, request);//处理中文文件名
            ExcelUtil.writeExcel(list, "recruit", filename, response);//调用Excel工具类生成Excel
        } catch (SSException e) {
            e.printStackTrace();
            LogClerk.errLog.error(e);
        }
    }

    /**
     * 导出所有的年度季度考核的成绩
     * @param request
     * @param response
     */
    @RequestMapping(value = "/quarter/query",method = RequestMethod.POST)
    public void exportYearQuarterByConditions(HttpServletRequest request,HttpServletResponse response,HttpSession session){
        try {
            int did ;
            if (Assert.isNull((int) session.getAttribute("queryQuarterDid"))){
                did = -1;
            }else {
                did = (int) session.getAttribute("queryQuarterDid");
            }
            int rid;

            if (Assert.isNull((int) session.getAttribute("queryQuarterRid"))){
                rid = -1;
            }else {
                rid = (int) session.getAttribute("queryQuarterRid");
            }
            int year;
            if (Assert.isNull( (int) session.getAttribute("queryQuarterYear"))){
                year = -1;
            }else {
                year =  (int) session.getAttribute("queryQuarterYear");
            }
            String username;
            if (Assert.isNull((String) session.getAttribute("queryQuarterUName"))){
                username = "";
            }else {
                username = (String) session.getAttribute("queryQuarterUName");
            }
            List<YearQueaterExportDto> list = exportService.exportYearQueaterByConditions(did, rid, year, username);
            String filename = "年度季度考核.xls";//设置下载时Excel的名称
            filename = ExcelUtil.encodeFilename(filename, request);//处理中文文件名
            ExcelUtil.writeExcel(list, "recruit", filename, response);//调用Excel工具类生成Excel
        } catch (SSException e) {
            e.printStackTrace();
            LogClerk.errLog.error(e);
        }
    }

    /**
     * 根据部门ID查询年度季度考核
     * @param did
     * @param response
     * @param request
     * @throws Exception
     */
    @RequestMapping(value = "/quarter/query/did/{did}")
    public void exportYearQuarterByDid(@PathVariable("did") int did,HttpServletResponse response, HttpServletRequest request)throws Exception{
        try {
            List<YearQueaterExportDto> list = exportService.queryQuarterByDid(did);
            String filename = "年度季度考核.xls";//设置下载时Excel的名称
            filename = ExcelUtil.encodeFilename(filename, request);//处理中文文件名
            ExcelUtil.writeExcel(list, "recruit", filename, response);//调用Excel工具类生成Excel
        } catch (SSException e) {
            e.printStackTrace();
            LogClerk.errLog.error(e);
        }
    }

    /**
     * 根据部门ID查询年度季度考核
     * @param uid
     * @param response
     * @param request
     * @throws Exception
     */
    @RequestMapping(value = "/quarter/query/uid/{uid}")
    public void exportYearQuarterByUid(@PathVariable("uid") int uid,HttpServletResponse response, HttpServletRequest request)throws Exception{
        try {
            List<YearQueaterExportDto> list = exportService.queryQuarterByUid(uid);

            String filename = "年度季度考核.xls";//设置下载时Excel的名称
            filename = ExcelUtil.encodeFilename(filename, request);//处理中文文件名
            ExcelUtil.writeExcel(list, "recruit", filename, response);//调用Excel工具类生成Excel
        } catch (SSException e) {
            e.printStackTrace();
            LogClerk.errLog.error(e);
        }
    }
}
