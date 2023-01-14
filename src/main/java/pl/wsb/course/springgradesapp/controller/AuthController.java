package pl.wsb.course.springgradesapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wsb.course.springgradesapp.model.Student;
import pl.wsb.course.springgradesapp.model.User;
import pl.wsb.course.springgradesapp.model.dto.StudentDto;
import pl.wsb.course.springgradesapp.model.dto.UserDto;
import jakarta.validation.Valid;
import pl.wsb.course.springgradesapp.service.StudentService;
import pl.wsb.course.springgradesapp.service.UserService;

import java.util.List;

@Controller
public class AuthController {

    private StudentService studentService;
    private UserService userService;

    public AuthController(UserService userService, StudentService studentService) {
        this.userService = userService;
        this.studentService = studentService;
    }

    // handler method to handle home page request
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/students")
    public String users(Model model){
        List<StudentDto> users = studentService.getAll();
        model.addAttribute("students", users);
        return "students";
    }
}