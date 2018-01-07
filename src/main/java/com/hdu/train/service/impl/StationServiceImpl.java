package com.hdu.train.service.impl;

import com.hdu.train.dao.StationDao;
import com.hdu.train.dao.StationNodeDao;
import com.hdu.train.service.StationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:50 18-1-7
 * @Modified By:
 */

@Service
public class StationServiceImpl implements StationService {
    @Resource
    private StationDao stationDao;

    @Override
    public List<String> getAllStation() {
        return stationDao.GetAllStation();
    }

    @Override
    public int getStationId(String stationName) {
        return stationDao.GetStationId(stationName);
    }

    @Override
    public String getStationName(int stationId) {
        return stationDao.GetStationName(stationId);
    }
}
