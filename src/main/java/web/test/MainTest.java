package web.test;

import web.dao.UserDaoImpl;
import web.models.User;
import web.service.UserService;
import web.service.UserServiceImpl;


public class MainTest {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl(new UserDaoImpl());

        userService.add(new User("name1", "lastName1"));

        userService.add(new User("name2", "lastName2"));
    }
}
