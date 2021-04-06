package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping()
    public ModelAndView allUsers(Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("usersList");
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView getUserById(@PathVariable("id") int id, Model model) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("getUserById");
        return modelAndView;
    }


}
