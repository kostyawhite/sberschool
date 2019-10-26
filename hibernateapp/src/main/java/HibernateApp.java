import services.UserService;
import models.User;

public class HibernateApp {

    public static void main(String[] args) {

        UserService userService = new UserService();

        User user = new User("Kostya");
        userService.saveUser(user);
        userService.findUser(1);

    }

}
