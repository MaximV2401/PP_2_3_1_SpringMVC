package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;


public interface UserService {


    public List<User> listUsers();
    public void add(User user);
    public User getUser(long id);
    public void delete(long id);
    public void update(long id, User user);
}
