package com.pandawork.home.service.system;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.system.Allot;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/5.
 */
public interface AllotService {

    /**
     * 新增管辖分配
     * @param allot
     * @throws SSException
     */
    public void addAllot(Allot allot)throws SSException;

    /**
     * 编辑管辖分配
     * @param allot
     * @throws SSException
     */
    public void updateAllot(Allot allot)throws SSException;

    /**
     * 根据用户ID查找
     * @param uid
     * @return
     * @throws SSException
     */
    public List<Allot> queryByUid(int uid)throws SSException;

    /**
     * 根据ID删除
     * @param id
     * @return
     * @throws SSException
     */
    public boolean delAllot(int id)throws SSException;

    /**
     * 列出所有
     * @return
     * @throws SSException
     */
    public List<Allot> listAll()throws SSException;

    /**
     * 计算总条数
     * @return
     * @throws SSException
     */
    public int countAll()throws SSException;

    /**
     * 根据用户ID查找所管辖的部门
     * @param uid
     * @return
     * @throws SSException
     */
    public List<Integer> queryDidByUid(int uid)throws SSException;

    /**
     * 根据部门ID查询
     * @param did
     * @return
     * @throws SSException
     */
    public Allot queryByDid(int did)throws SSException;
}
