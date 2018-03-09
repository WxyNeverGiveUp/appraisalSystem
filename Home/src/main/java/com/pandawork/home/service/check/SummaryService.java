package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.Summary;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/30.
 */
public interface SummaryService {
    /**
     * 新增年度总结报告
     * @param summary
     * @throws SSException
     */
    public void addSummary(Summary summary)throws SSException;

    /**
     * 编辑年度总结报告
     * @param summary
     * @throws SSException
     */
    public void updateSummary(Summary summary)throws SSException;

    /**
     * 对年度总结报告进行打分
     * @param summary
     * @throws SSException
     */
    public void updateScore(Summary summary)throws SSException;

    /**
     * 根据被考核用户ID和当前年份查找年度总结报告
     * @param summary
     * @return
     * @throws SSException
     */
    public List<Summary> queryByUser(Summary summary)throws SSException;

    /**
     * 列出所有的年度总结
     * @return
     * @throws SSException
     */
    public List<Summary> listAll()throws SSException;

    /**
     * 根据ID查找年度总结
     * @param id
     * @return
     * @throws SSException
     */
    public Summary queryById(int id)throws SSException;

    /**
     * 根据部门ID查找年度总结
     * @param did
     * @return
     * @throws SSException
     */
    public List<Summary> queryByDid(int did)throws SSException;

    /**
     * 根据年份查找
     * @param year
     * @return
     * @throws SSException
     */
    public List<Summary> queryByYear(int year)throws SSException;

    /**
     * 根据被考核用户ID和年份查找
     * @param beCheckId
     * @param year
     * @return
     * @throws SSException
     */
    public Summary queryByUidAndYear(int beCheckId,int year)throws SSException;
}
