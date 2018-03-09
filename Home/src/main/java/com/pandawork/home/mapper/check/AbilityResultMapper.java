package com.pandawork.home.mapper.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.AbilityResult;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/1.
 */
public interface AbilityResultMapper {
    /**
     * 增加考核结果
     * @param abilityResult
     * @throws SSException
     */
    public void addResult(@Param("abilityResult") AbilityResult abilityResult)throws SSException;

    /**
     * 编辑考核结果
     * @param abilityResult
     * @throws SSException
     */
    public void updateResult(@Param("abilityResult") AbilityResult abilityResult)throws SSException;

    /**
     * 删除考核结果
     * @param id
     * @return
     * @throws SSException
     */
    public boolean delResult(@Param("id") int id)throws SSException;

    /**
     * 计算总条数
     * @return
     * @throws SSException
     */
    public int countAll()throws SSException;

    /**
     * 根据部门ID查找结果
     * @param did
     * @return
     * @throws SSException
     */
    public List<AbilityResult> queryByDid(@Param("did") int did)throws SSException;

    /**
     * 列出所有的结果
     * @return
     * @throws SSException
     */
    public List<AbilityResult> listAll()throws SSException;

    public AbilityResult queryByTidAndUid(@Param("testId") int testId,@Param("uid") int uid)throws SSException;


}
