package web.service;

import org.springframework.stereotype.Service;
import web.model.User;

import java.util.List;

@Service
public interface UserService {


    public List<User> listUsers();
    public void add(User user);
    public User getUser(int id);
    public void delete(int id);
    public void update(int id, User user);
}
