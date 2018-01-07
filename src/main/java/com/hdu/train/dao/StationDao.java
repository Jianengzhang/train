package com.hdu.train.dao;

import java.util.List;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:34 18-1-7
 * @Modified By:
 */
public interface StationDao {
    //获取站名
    String GetStationName(int stationId);
    //获取站ID
    int GetStationId(String stationName);
    //获取所有站点信息
    List<String> GetAllStation();
}
