package com.pandawork.home.service.query.impl;

import com.pandawork.core.common.exception.SSException;
import com.pandawork.core.common.log.LogClerk;
import com.pandawork.core.common.util.Assert;
import com.pandawork.home.common.dto.YearMonthExportDto;
import com.pandawork.home.common.dto.YearQueaterExportDto;
import com.pandawork.home.common.exception.ChException;
import com.pandawork.home.mapper.query.ExportMapper;
import com.pandawork.home.service.query.ExportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Taoyongpan on 2017/9/18.
 */

@Service(value = "exportService")
public class ExportServiceImpl implements ExportService {

    @Autowired
    ExportMapper exportMapper;
    @Override
    public List<YearMonthExportDto> exportYearMonth() throws SSException {
        try {
            return exportMapper.exportYearMonth();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }

    @Override
    public List<YearMonthExportDto> exportYearMonthByConditions(int did, int rid, int year, String username) throws SSException {
        try {
            return exportMapper.exportYearMonthByConditions(did, rid, year, username);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }

    @Override
    public List<YearMonthExportDto> queryMonthByDid(int did) throws SSException {
        try {
            if (Assert.isNull(did)){
                return null;
            }
            return exportMapper.queryMonthByDid(did);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }

    @Override
    public List<YearMonthExportDto> queryMonthByUid(int uid) throws SSException {
        try {
            if (Assert.isNull(uid)){
                return null;
            }
            return exportMapper.queryMonthByUid(uid);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }


    @Override
    public List<YearQueaterExportDto> exportYearQueater() throws SSException {
        try {
            return exportMapper.exportYearQueater();
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }

    @Override
    public List<YearQueaterExportDto> exportYearQueaterByConditions(int did, int rid, int year, String username) throws SSException {
        try {
            return exportMapper.exportYearQueaterByConditions(did, rid, year, username);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }

    @Override
    public List<YearQueaterExportDto> queryQuarterByDid(int did) throws SSException {
       try {
           if (Assert.isNull(did)){
               return null;
           }
           return exportMapper.queryQuarterByDid(did);
       }catch (Exception e){
           LogClerk.errLog.error(e);
           throw SSException.get(ChException.ExportFailed);
       }
    }

    @Override
    public List<YearQueaterExportDto> queryQuarterByUid(int uid) throws SSException {
        try {
            if (Assert.isNull(uid)){
                return null;
            }
            return exportMapper.queryQuarterByUid(uid);
        }catch (Exception e){
            LogClerk.errLog.error(e);
            throw SSException.get(ChException.ExportFailed);
        }
    }


}
