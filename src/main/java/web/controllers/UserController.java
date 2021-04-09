package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.models.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ModelAndView allUsers() {
        List<User> list = userService.allUsers();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersList");
        modelAndView.addObject("allUsers", list);
        return modelAndView;
    }

    @GetMapping("/getById/${id}")
    public ModelAndView getUserById(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", userService.getById(id));
        modelAndView.setViewName("getUserById");
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView updatePage(@PathVariable("id") int id){
        User user = userService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("updatePage");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @PostMapping("/update")
    public  ModelAndView updateUser(@ModelAttribute("user") User user){
        System.out.println("kl");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/user");
        userService.update(user);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView addUser(){
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteUser(){
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }
}
