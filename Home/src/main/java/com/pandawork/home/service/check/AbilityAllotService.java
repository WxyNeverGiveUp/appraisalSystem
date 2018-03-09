package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.AllotDto;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/23.
 */
public interface AbilityAllotService {

    /**
     * 能力指标测试一般员工的测试范围
     * @param did
     * @return
     * @throws SSException
     */
    public List<AllotDto> generalCheck(int did)throws SSException;

    /**
     * 部门副经理的测试范围，需要添加上直系副总经理
     * @param did
     * @return
     * @throws SSException
     */
    public List<AllotDto> deputyCheck(int did)throws SSException;

    /**
     * 部门经理的测试范围，需要添加上直系的副总经理
     * @param did
     * @return
     * @throws SSException
     */
    public List<AllotDto> dManagerCheck(int did)throws SSException;

    /**
     * 总经理的考核范围
     * @return
     * @throws SSException
     */
    public List<AllotDto> topManagerCheck()throws SSException;

    /**
     * 副总经理查询  用户ID
     * @param dids
     * @return
     * @throws SSException
     */
    public List<AllotDto> deputyManagerCheck(List<Integer> dids)throws SSException;

    /**
     * 根据用户Id查找
     * @param uid
     * @return
     * @throws SSException
     */
    public AllotDto queryByUid(int uid)throws SSException;


    /**
     * 部门副总经理年度绩效考核
     * @param did
     * @return
     * @throws SSException
     */
    public List<AllotDto> queryGeneralByDid(int did)throws SSException;

    /**
     * 部门经理年度绩效考核
     * @param did
     * @return
     * @throws SSException
     */
    public List<AllotDto> queryDeputyByDid(int did)throws SSException;

    /**
     * 副总经理年度绩效考核
     * @param dids
     * @return
     * @throws SSException
     */
    public List<AllotDto> queryManageByDid(List<Integer> dids)throws SSException;

    /**
     * 总经理考核
     * @return
     * @throws SSException
     */
    public List<AllotDto> queryDeputyManagerCheck()throws SSException;

    /**
     * 月度考核总经理考核
     * @return
     * @throws SSException
     */
    public List<AllotDto> queryByTopManagerCheck()throws SSException;
}
