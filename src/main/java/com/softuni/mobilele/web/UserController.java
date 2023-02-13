package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.dtos.binding.UserLoginFormDTO;
import com.softuni.mobilele.domain.dtos.binding.UserRegisterFormDTO;
import com.softuni.mobilele.domain.dtos.models.UserModel;
import com.softuni.mobilele.domain.dtos.views.UserRoleViewDTO;
import com.softuni.mobilele.services.role.UserRoleService;
import com.softuni.mobilele.services.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserRoleService userRoleService;
    private final UserService userService;

    public UserController(UserRoleService userRoleService, UserService userService) {
        this.userRoleService = userRoleService;
        this.userService = userService;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView){
        List<UserRoleViewDTO> roleViewDTOS = this.userRoleService.getAll();

        modelAndView.addObject("roles", roleViewDTOS);

        return super.view("auth-register", modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView postRegister(@ModelAttribute UserRegisterFormDTO userRegister){
        // userRegister -> service -> username name -> save to db -> redirect auth-
        this.userService.registerUser(userRegister);
        return super.redirect("login");
    }

    @GetMapping("/login")
    public ModelAndView getLogin(){
        return super.view("auth-login");
    }

    @PostMapping("/login")
    public ModelAndView postLogin(UserLoginFormDTO userLoginForm){
        UserModel userModel = this.userService.loginUser(userLoginForm);

        return userModel.isValid()
                ? super.redirect("/")
                : super.redirect("/login");
    }

    @PostMapping("/logout")
    public ModelAndView postLogout(){
        this.userService.logout();
        return super.redirect("/");
    }
}
