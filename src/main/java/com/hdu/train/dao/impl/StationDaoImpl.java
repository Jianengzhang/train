package com.hdu.train.dao.impl;

import com.hdu.train.dao.SessionFactoryUnit;
import com.hdu.train.dao.StationDao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:35 18-1-7
 * @Modified By:
 */

@Repository("stationDao")
public class StationDaoImpl implements StationDao{
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List<String> GetAllStation() {
        List stationList = SessionFactoryUnit.openSession(sessionFactory).createQuery("select s.stationName from Station s").list();
        SessionFactoryUnit.closeSession(SessionFactoryUnit.openSession(sessionFactory));
        return (List<String>)stationList;
    }

    @Override
    public int GetStationId(String stationName) {
        List stationList = SessionFactoryUnit.openSession(sessionFactory).createQuery("select s.stationId from Station s where s.stationName = '"+ stationName+"'").list();
        SessionFactoryUnit.closeSession(SessionFactoryUnit.openSession(sessionFactory));
        return ((List<Integer>) stationList).get(0).intValue();
    }

    @Override
    @SuppressWarnings("unchecked")
    public String GetStationName(int stationId) {
        List<String> stationList = SessionFactoryUnit.openSession(sessionFactory).createQuery("select s.stationName from Station s where s.stationId = '"+ stationId+"'").list();
        SessionFactoryUnit.closeSession(SessionFactoryUnit.openSession(sessionFactory));
        if (stationList.size()>0){
            return stationList.get(0);
        }
        else return "0";


    }
}
