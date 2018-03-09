package com.pandawork.home.mapper.query;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.dto.YearQueaterExportDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/2.
 */
public interface YearQueaterMapper {

    /**
     * 显示季度查询结果
     * @return
     * @throws SSException
     */
    public List<YearQueaterExportDto> listAll()throws SSException;

    /**
     * 根据条件查询
     * @param did
     * @param rid
     * @param year
     * @param username
     * @return
     * @throws SSException
     */
    public List<YearQueaterExportDto> queryDtoByConditions(@Param("did") int did, @Param("rid") int rid, @Param("year") int year, @Param("username") String username)throws SSException;

    /**
     * 根据用户ID查找
     * @param uid
     * @return
     * @throws SSException
     */
    public List<YearQueaterExportDto> queryByUid(@Param("uid") int uid)throws SSException;

    /**
     * 根据部门ID查找
     * @param did
     * @return
     * @throws SSException
     */
    public List<YearQueaterExportDto> queryByDid(@Param("did") int did)throws SSException;

    /**
     * 根据用户ID和年份查找
     * @param uid
     * @return
     * @throws SSException
     */
    public YearQueaterExportDto queryByUidAndYear(@Param("uid") int uid,@Param("year") int year)throws SSException;
}
