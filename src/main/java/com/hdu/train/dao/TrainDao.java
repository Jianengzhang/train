package com.hdu.train.dao;

import com.hdu.train.pojo.Train;

import java.util.List;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:41 18-1-7
 * @Modified By:
 */
public interface TrainDao {
    //所有车次信息
    List<Train> GetAllTrain();
    //获取车次名
    String getTrainName(int trainId);
}
