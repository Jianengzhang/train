package com.hdu.train.dao;

import com.hdu.train.pojo.StationNode;

import java.util.List;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:38 18-1-7
 * @Modified By:
 */
public interface StationNodeDao {
    //获取直达信息
    List<StationNode> GetDirectStation(int stationId1, int stationId2);
    //获取中转信息
    StationNode GetTransferStation(int stationId1,int stationId2,int trainId);
}
