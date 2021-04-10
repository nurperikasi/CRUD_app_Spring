package web.test;

import web.dao.UserDaoImpl;
import web.models.User;
import web.service.UserService;
import web.service.UserServiceImpl;


public class MainTest {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl(new UserDaoImpl());

        User user1 = new User();
        user1.setName("nora");
        user1.setLastName("lola");
        userService.add(user1);

    }
}
