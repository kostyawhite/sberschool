package ru.sber.e4;

import ru.sber.e4.models.User;
import ru.sber.e4.services.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateApp {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("ru.sber.e4.models");
        EntityManager em = entityManagerFactory.createEntityManager();

        UserService userService = new UserService();

        User user = new User("Kostya");
        userService.saveUser(user);
        userService.findUser(1);

    }

}
