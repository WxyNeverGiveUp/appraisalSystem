package com.pandawork.home.service.check.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.dto.TestPositionDto;
import com.pandawork.home.common.entity.check.TestPosition;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.check.TestPositionMapper;
import com.pandawork.home.service.check.TestPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/14.
 */
@Service(value = "testPositionService")
public class TestPositionServiceImpl implements TestPositionService {
    @Autowired
    TestPositionMapper testPositionMapper;
    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public void addTestPosition(TestPosition testPosition) throws SSException {
        try {
            if (Assert.isNull(testPosition)){
                return;
            }
            testPositionMapper.addTestPosition(testPosition);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.AddTestPositionFailed);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {SSException.class,Exception.class, RuntimeException.class})
    public boolean delTestPosition(int id) throws SSException {
        try {
            if (Assert.isNull(id)){
                return false;
            }
            return testPositionMapper.delTestPosition(id);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.DelTestPositionFailed);
        }
    }

    @Override
    public List<TestPosition> queryByTestId(int testId) throws SSException {
        try {
            if (Assert.isNull(testId)){
                return null;
            }
            return testPositionMapper.queryByTestId(testId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryTestPositionByTestIdFailed);
        }
    }

    @Override
    public List<TestPositionDto> queryDtoByTesId(int testId) throws SSException {
        try {
            if(Assert.isNull(testId)){
                return null;
            }
            return testPositionMapper.queryDtoByTestId(testId);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.QueryPositionByDidFailed);
        }
    }
}
