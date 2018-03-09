package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.JoinTest;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/12.
 */
public interface JoinTestService {
    /**
     * 新增考核分配
     * @param joinTest
     * @throws SSException
     */
    public void addCheck(JoinTest joinTest)throws SSException;

    /**
     * 根据ID移除考核分配
     * @param tid
     * @return
     * @throws SSException
     */
    public boolean delById(int tid,int uid)throws SSException;

    /**
     * 根据ID查找
     * @param id
     * @return
     * @throws SSException
     */
    public JoinTest queryById(int id)throws SSException;

    /**
     * 根据用户ID查找
     * @param uid
     * @return
     * @throws SSException
     */
    public List<JoinTest> queryByUid(int uid)throws SSException;

    /**
     * 根据测试的ID查找
     * @param testId
     * @return
     * @throws SSException
     */
    public List<JoinTest> queryByTid(int testId)throws SSException;

    /**
     * 根据用户ID和测试的ID查找
     * @param uid
     * @param tid
     * @return
     * @throws SSException
     */
    public JoinTest queryByUidAndTid(int uid ,int tid)throws SSException;

    /**
     * 列出 所有
     * @return
     * @throws SSException
     */
    public List<JoinTest> listAll()throws SSException;

    /**
     * 此次参与的考核时候否被考核
     * @param joinTest
     * @throws SSException
     */
    public void isJoin(JoinTest joinTest)throws SSException;


}
