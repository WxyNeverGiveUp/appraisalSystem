package com.pandawork.home.mapper.system;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.system.Power;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/8/13.
 */
public interface PowerMapper {

    /**
     * 新增用户权限
     * @param power
     * @throws SSException
     */
    public void addPower(@Param("power") Power power)throws SSException;

    /**
     * 根据ID删除权限
     * @param id
     * @return
     * @throws SSException
     */
    public boolean delPower(@Param("id") int id)throws SSException;

    /**
     * 根据ID更新权限
     * @param power
     * @return
     * @throws SSException
     */
    public void updatePower(@Param("power") Power power)throws SSException;

    /**
     * 根据ID查找权限
     * @param id
     * @return
     * @throws SSException
     */
    public Power queryById(@Param("id") int id)throws SSException;

    /**
     * 根据 权限等级查找权限
     * @param power
     * @return
     * @throws SSException
     */
    public Power queryByPower(@Param("power") int power)throws SSException;

    /**
     * 列出所有权限等级
     * @return
     * @throws SSException
     */
    public List<Power> listAll()throws SSException;
}
