package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.dao.UserDao;
import web.model.ContactInfo;
import web.model.User;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {


    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(User newUser) {
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }
}
