package com.hdu.train.dao.impl;

import com.hdu.train.dao.SessionFactoryUnit;
import com.hdu.train.dao.TrainDao;
import com.hdu.train.pojo.Train;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:42 18-1-7
 * @Modified By:
 */
@Repository("trainDao")
public class TrainDaoImpl implements TrainDao{
    @Resource
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public List<Train> GetAllTrain() {
        List<Train> trainList = SessionFactoryUnit.openSession(sessionFactory).createQuery("from Train t").list();
        SessionFactoryUnit.closeSession(SessionFactoryUnit.openSession(sessionFactory));
        return trainList;
    }

    @SuppressWarnings("unchecked")
    public String getTrainName(int trainId) {
        List<String> trainList = SessionFactoryUnit.openSession(sessionFactory).createQuery("Select t.trainName from Train t where t.trainId="+ trainId).list();
        SessionFactoryUnit.closeSession(SessionFactoryUnit.openSession(sessionFactory));
        return trainList.get(0);
    }
}
