package web.dao;

import web.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    public void save(User user);

    public void delete(int id);

    public void update(User user);

    public Optional<User> findById(int id);

    public List<User> findAll();

}
