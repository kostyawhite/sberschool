import services.UserService;
import models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;

public class HibernateApp {

    public static void main(String[] args) {

//        Java Persistence
//        EntityManagerFactory entityManagerFactory;
//        entityManagerFactory = Persistence.createEntityManagerFactory( "org.hibernate.tutorial.jpa" );
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist( new User("John"));
//        entityManager.getTransaction().commit();
//        entityManager.close();

        UserService userService = new UserService();

        User user = new User("Kostya");
        userService.saveUser(user);
        userService.findUser(1);
        userService.saveUser(new User("Kseniya"));

    }

}
