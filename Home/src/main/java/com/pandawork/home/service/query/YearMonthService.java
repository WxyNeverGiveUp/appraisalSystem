package com.pandawork.home.service.query;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.YearMonthExportDto;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/17.
 */
public interface YearMonthService {

    /**
     * 列出所有的考核成绩
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> listAll()throws SSException;

    /**
     * 根据条件查询
     * @param did
     * @param rid
     * @param year
     * @param username
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> queryByConditions(int did,int rid,int year,String username)throws SSException;

    /**
     * 根据用户ID查找
     * @param uid
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> queryByUid(int uid)throws SSException;

    /**
     * 根据部门ID查找
     * @param did
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> queryByDid(int did)throws SSException;

    /**
     * 副总经理查询所管辖的人
     * @param dids
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> queryByAllot(List<Integer> dids)throws SSException;

    /**
     * 根据用户ID和年份查找
     * @param uid
     * @return
     * @throws SSException
     */
    public YearMonthExportDto queryByUidAndYear(int uid,int year)throws SSException;
}
