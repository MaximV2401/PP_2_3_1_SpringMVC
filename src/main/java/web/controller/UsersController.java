package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.dao.UserDaoImpl;
import web.model.User;

@Controller
@RequestMapping("/users")
public class UsersController {

    private final UserDao userDaoImpl;

    @Autowired
    public UsersController(UserDaoImpl userDaoImpl) {
        this.userDaoImpl = userDaoImpl;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("list", userDaoImpl.listUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userDaoImpl.getUser(id));
        return "user";
    }
    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }



    @PostMapping()
    public String userCreate(@ModelAttribute("user") User user) {
        userDaoImpl.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userDaoImpl.getUser(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userDaoImpl.update(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userDaoImpl.delete(id);
        return "redirect:/user";
    }

}
