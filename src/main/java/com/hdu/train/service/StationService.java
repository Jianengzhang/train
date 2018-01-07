package com.hdu.train.service;

import java.util.List;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:49 18-1-7
 * @Modified By:
 */
public interface StationService {
    List<String> getAllStation();
    int getStationId(String stationName);
    String getStationName(int stationId);
}
