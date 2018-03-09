package com.pandawork.home.mapper.query;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.YearMonthExportDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/2.
 */
public interface YearMonthMapper {
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
    public List<YearMonthExportDto> queryByConditions(@Param("did") int did,@Param("rid") int rid, @Param("year") int year,@Param("username") String username)throws SSException;

    /**
     * 根据用户ID查找
     * @param uid
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> queryByUid(@Param("uid") int uid)throws SSException;

    /**
     * 根据部门ID查找
     * @param did
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> queryByDid(@Param("did") int did)throws SSException;

    /**
     * 副总经理查询所管辖的人
     * @param dids
     * @return
     * @throws SSException
     */
    public List<YearMonthExportDto> queryByAllot(@Param("dids") List<Integer> dids)throws SSException;

    /**
     * 根据用户ID查找
     * @param uid
     * @return
     * @throws SSException
     */
    public YearMonthExportDto queryByUidAndYear(@Param("uid") int uid,@Param("year") int year)throws SSException;
}
