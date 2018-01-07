package com.hdu.train.service.impl;

import com.hdu.train.dao.TrainDao;
import com.hdu.train.pojo.Train;
import com.hdu.train.service.TrainService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:48 18-1-7
 * @Modified By:
 */

@Service
public class TrainServiceImpl implements TrainService {
    @Resource
    private TrainDao trainDao;

    public List<Train> getAllTrain() {
        return trainDao.GetAllTrain();
    }

    @Override
    public String getTrainName(int stationId) {
        return trainDao.getTrainName(stationId);
    }
}
