package web.service;

import web.models.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();
    void add(User user);
    void delete(User user);
    void update(User user);
    User getById(int id);
}
