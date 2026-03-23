package hiber.dao;

import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private Session session;

    @Override
    @Transactional
    public void add(User user) {
        session.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserByCar(String model, int series) {
        String hql = "SELECT u FROM User u JOIN u.car c WHERE c.model = :model AND c.series = :series";

        return session.createQuery(hql, User.class)
                .setParameter("model", model)
                .setParameter("series", series)
                .getSingleResult();
    }

    @Override
    @Transactional(readOnly = true)
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = session.createQuery("from User");
        return query.getResultList();
    }

}
