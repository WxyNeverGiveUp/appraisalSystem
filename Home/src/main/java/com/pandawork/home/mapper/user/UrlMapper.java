package com.pandawork.home.mapper.user;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.user.Url;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/10/3.
 */
public interface UrlMapper {

    public List<Url> queryByPower(@Param("power") int power)throws SSException;


    public  Url queryByUrl(@Param("url") String url)throws SSException;
}
