package com.hdu.train.service.impl;

import com.hdu.train.dao.StationNodeDao;
import com.hdu.train.pojo.StationNode;
import com.hdu.train.service.StationNodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:52 18-1-7
 * @Modified By:
 */
@Service
public class StationNodeServiceImpl implements StationNodeService {
    @Resource
    private StationNodeDao stationNodeDao;

    @Override
    public List<StationNode> getDirectStation(int stationId1, int stationId2) {
        List<StationNode> stationNodes = new ArrayList<>();
        stationNodes = stationNodeDao.GetDirectStation(stationId1, stationId2);

        return stationNodes;
    }

    @Override
    public StationNode getTransferTrain(int stationId1, int stationId2, int trainId) {
        return stationNodeDao.GetTransferStation(stationId1, stationId2, trainId);
    }
}
