package ru.sber.e4.services;

import ru.sber.e4.dao.UserDao;
import ru.sber.e4.models.User;
import ru.sber.e4.models.Vehicle;

import java.util.List;

public class UserService {

    private UserDao userDao = new UserDao();

    public UserService() {
    }

    public void saveUser(User user) {
        userDao.save(user);
    }

    public User findUser(int id) {
        return userDao.findById(id);
    }

    public void updateUser(User user) {
        userDao.update(user);
    }

    public void deleteUser(User user) {
        userDao.delete(user);
    }

}