package com.hdu.train.dao.impl;

import com.hdu.train.dao.SessionFactoryUnit;
import com.hdu.train.dao.StationNodeDao;
import com.hdu.train.pojo.StationNode;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:40 18-1-7
 * @Modified By:
 */

@Repository("stationNodeDao")
public class StationNodeImpl implements StationNodeDao{
    @Resource
    private SessionFactory sessionFactory;

    @Override
    @SuppressWarnings("unchecked")
    public List<StationNode> GetDirectStation(int stationId1, int stationId2) {
        List<StationNode> stationList = SessionFactoryUnit.openSession(sessionFactory).createQuery("from StationNode SN where SN.stationId1 = "+ stationId1 +" and SN.stationId2="+stationId2).list();
        System.out.println(stationList);
        SessionFactoryUnit.closeSession(SessionFactoryUnit.openSession(sessionFactory));
        return stationList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public StationNode GetTransferStation(int stationId1, int stationId2, int train) {
        List<StationNode> stationList = SessionFactoryUnit.openSession(sessionFactory).createQuery("from StationNode SN where SN.stationId1 = "+ stationId1 +" and SN.stationId2="+stationId2).list();
        System.out.println(stationList);
        SessionFactoryUnit.closeSession(SessionFactoryUnit.openSession(sessionFactory));
        return stationList.get(0);
    }
}
