package com.hdu.train.service;

import com.hdu.train.pojo.StationNode;

import java.util.List;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:51 18-1-7
 * @Modified By:
 */
public interface StationNodeService {
    List<StationNode> getDirectStation(int stationId1, int stationId2);
    StationNode getTransferTrain(int stationId1, int stationId2, int trainId);
}
