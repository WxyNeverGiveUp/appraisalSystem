package com.pandawork.home.service.user.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.home.common.entity.user.Url;
import com.pandawork.home.mapper.user.UrlMapper;
import com.pandawork.home.service.user.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/10/3.
 */
@Service(value = "urlService")
public class UrlServiceImpl implements UrlService {
    @Autowired
    UrlMapper urlMapper;
    @Override
    public List<Url> queryByPower(int power) throws SSException {
        return urlMapper.queryByPower(power);
    }

    @Override
    public Url queryByUrl(String url) throws SSException {
        return urlMapper.queryByUrl(url);
    }
}
