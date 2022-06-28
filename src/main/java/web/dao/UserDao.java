package web.dao;

import web.model.User;

import java.util.List;

public interface UserDao {


    public List<User> listUsers();
    public void add(User user);
    public User getUser(int id);
    public void delete(int id);
    public void update(int id, User user);
}
