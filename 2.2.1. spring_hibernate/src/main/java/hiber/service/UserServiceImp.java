package hiber.service;

import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserServiceImp implements UserService {

   private final UserDao userDao;

   @Autowired
   public UserServiceImp (UserDao userDao) {
      this.userDao = userDao;
   }

   @Override
   @Transactional
   public void add(User user) {
      userDao.add(user);
   }

   @Override
   @Transactional(readOnly = true)
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Override
   @Transactional(readOnly = true)
   public User getUserByCar(String model, int series) {
      return userDao.getUserByCar(model, series);
   }

}
