package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.WorkDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/30.
 */
public interface WorkDetailMapper {
    /**
     * 新增工作计划详情
     * @param workDetail
     * @throws SSException
     */
    public void addWorkDetail(@Param("workDetail") WorkDetail workDetail)throws SSException;

    /**
     * 编辑工作计划详情
     * @param workDetail
     * @throws SSException
     */
    public void updateWorkDetail(@Param("workDetail") WorkDetail workDetail)throws SSException;

    /**
     * 查出某一次工作计划考核的所有条数
     * @param wid
     * @return
     * @throws SSException
     */
    public List<WorkDetail> queryByWId(@Param("wid") int wid)throws SSException;

    /**
     * 删除
     * @param id
     * @return
     * @throws SSException
     */
    public boolean delWorkDetail(@Param("id") int id)throws SSException;

    /**
     * 根据ID差找
     * @param id
     * @return
     * @throws SSException
     */
    public WorkDetail queryById(@Param("id") int id)throws SSException;

    /**
     * 根据被考核用户ID和工作计划ID查找
     * @param uid
     * @param wid
     * @return
     * @throws SSException
     */
    public List<WorkDetail> queryByUidAndWid(@Param("uid") int uid,@Param("wid") int wid)throws SSException;

    /**
     * 打分
     * @param workDetail
     * @return
     * @throws SSException
     */
    public void marking(@Param("workDetail") WorkDetail workDetail)throws SSException;
    /**
     * 被考核 人员月末新增自己的工作完成情况
     * @param workDetail
     * @throws SSException
     */
    public void addWorkCompletion(@Param("workDetail") WorkDetail workDetail)throws SSException;
}
