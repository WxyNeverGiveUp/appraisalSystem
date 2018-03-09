package com.pandawork.home.service.system;

import com.pandawork.home.common.entity.system.Power;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/13.
 */
public interface PowerService {
    /**
     * 新增权限
     * @param power
     * @throws Exception
     */
    public void addPower(Power power)throws Exception;

    /**
     * 根据ID删除权限
     * @param id
     * @return0
     * @throws Exception
     */
    public boolean delPower(int id)throws Exception;

    /**
     * 更新权限具体信息
     * @param power
     * @return
     * @throws Exception
     */
    public void updatePower(Power power)throws Exception;
    /**
     * 根据ID查找权限
     * @param id
     * @return
     * @throws Exception
     */
    public Power queryById(int id)throws Exception;

    /**
     * 根据权限等级查找权限
     * @param power
     * @return
     * @throws Exception
     */
    public Power queryByPower(int power)throws Exception;

    /**
     * 列出所有权限
     * @return
     * @throws Exception
     */
    public List<Power> listAll()throws Exception;
}
