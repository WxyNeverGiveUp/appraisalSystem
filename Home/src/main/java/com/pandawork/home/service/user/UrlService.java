package com.pandawork.home.service.user;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.user.Url;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/10/3.
 */
public interface UrlService {


    public List<Url> queryByPower(int power)throws SSException;

    public  Url queryByUrl(String url)throws SSException;
}
