package com.pandawork.home.service.check;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.check.AbilityResult;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/1.
 */
public interface AbilityResultService {

    /**
     * 增加考核结果
     * @param abilityResult
     * @throws SSException
     */
    public void addResult(AbilityResult abilityResult)throws SSException;

    /**
     * 编辑考核结果
     * @param abilityResult
     * @throws SSException
     */
    public void updateResult(AbilityResult abilityResult)throws SSException;

    /**
     * 删除考核结果
     * @param id
     * @return
     * @throws SSException
     */
    public boolean delResult(int id)throws SSException;

    /**
     * 计算总条数
     * @return
     * @throws SSException
     */
    public int coutAll()throws SSException;

    /**
     * 根据部门ID查找结果
     * @param did
     * @return
     * @throws SSException
     */
    public List<AbilityResult> queryByDid(int did)throws SSException;

    /**
     * 列出所有的结果
     * @return
     * @throws SSException
     */
    public List<AbilityResult> listAll()throws SSException;

    public AbilityResult queryByTidAndUid(int testId,int uid)throws SSException;


}
