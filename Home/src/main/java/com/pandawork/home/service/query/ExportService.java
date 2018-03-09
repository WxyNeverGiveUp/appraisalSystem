package com.pandawork.home.service.query;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.YearMonthExportDto;
import com.pandawork.home.common.dto.YearQueaterExportDto;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/18.
 */
public interface ExportService {

    /**
     * 导出所有用户年度月度考核成绩信息
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> exportYearMonth()throws SSException;

    /**
     * 多条件查询
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> exportYearMonthByConditions(int did,int rid,int year,String username)throws SSException;

    /**
     * 根据部门ID查询年度月度考核
     * @param did
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> queryMonthByDid(int did)throws SSException;

    /**
     * 根据用户ID查询年度月度考核
     * @param uid
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> queryMonthByUid(int uid)throws SSException;
    /**
     * 导出所有用户年度季度考核成绩信息
     * @return
     * @throws SSException
     */
    public List<YearQueaterExportDto> exportYearQueater()throws SSException;


    /**
     * 多条件季度查询
     * @return
     * @throws SSException
     */
    public List<YearQueaterExportDto> exportYearQueaterByConditions(int did,int rid,int year,String username)throws SSException;

    /**
     * 根据用户ID查找年度季度查询
     * @param did
     * @return
     * @throws SSException
     */
    public List<YearQueaterExportDto> queryQuarterByDid(int did)throws SSException;

    /**
     * 根据用户ID查找 年度季度成绩
     * @param uid
     * @return
     * @throws SSException
     */
    public List<YearQueaterExportDto> queryQuarterByUid(int uid)throws SSException;
}
