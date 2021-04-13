package web.dao;

import org.springframework.stereotype.Repository;
import web.models.Role;
import web.models.User;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> allUsers() {
        return  entityManager.createQuery("select u from User u",User.class).getResultList();
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getById(int id) {
        TypedQuery<User> query = entityManager.createQuery("select u from User u where u.id=:id",User.class);
        query.setParameter("id", id);
        return query.getResultList().stream().findAny().orElse(null);
    }
}
