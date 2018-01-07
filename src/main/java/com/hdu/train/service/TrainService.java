package com.hdu.train.service;

import com.hdu.train.pojo.Train;

import java.util.List;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:48 18-1-7
 * @Modified By:
 */
public interface TrainService {
    List<Train> getAllTrain();
    String getTrainName(int StationId);
}
