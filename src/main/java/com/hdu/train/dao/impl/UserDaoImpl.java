package com.hdu.train.dao.impl;

import com.hdu.train.dao.UserDao;
import com.hdu.train.pojo.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: JianengZhang
 * @Description
 * @Date: Create in 15:44 18-1-7
 * @Modified By:
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Resource
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

    private Session openSession() {
        return this.sessionFactory.openSession();
    }

    //关闭Session
    public void closeSession(Session session) {
        if (null != session) {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public User findUserByUserName(String userName) {

        List<User> list = openSession().createQuery("select u.userId as userId,u.userName as userName,u.password as password from User u" + " where u.userName = " + userName).setResultTransformer(Transformers.aliasToBean(User.class)).list();
        if (list.size() > 0) {
            closeSession(openSession());
            return list.get(0);
        } else {
            closeSession(openSession());
            return null;
        }
    }

}
