package web.dao;

import org.springframework.stereotype.Component;
import web.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class UserDaoImpl implements UserDao{

    private static int USER_COUNT;
    public UserDaoImpl() {}

    private static Map<Integer, User> map = new HashMap<>();

    static {
        User user1 = new User(++USER_COUNT, "name1", "lastName2");
        User user2 = new User(++USER_COUNT, "name2", "lastName2");
        User user3 = new User(++USER_COUNT, "name3", "lastName3");
        map.put(user1.getId(), user1);
        map.put(user2.getId(), user2);
        map.put(user3.getId(), user3);
    }

    @Override
    public List<User> allUsers() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void add(User user) {
        map.put(++USER_COUNT, user);
    }

    @Override
    public void delete(User user) {
        map.remove(user.getId(), user);
    }

    @Override
    public void update(User user) {
        map.put(user.getId(), user);
    }

    @Override
    public User getById(int id) {
        map.get(id);
        return null;
    }
}
