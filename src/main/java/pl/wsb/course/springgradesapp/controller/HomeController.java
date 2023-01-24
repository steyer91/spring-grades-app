package pl.wsb.course.springgradesapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.wsb.course.springgradesapp.model.User;
import pl.wsb.course.springgradesapp.repository.UserRepository;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepo;

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    }
