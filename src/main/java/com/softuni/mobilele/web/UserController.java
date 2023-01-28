package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.dtos.banding.UserRegisterFormDTO;
import com.softuni.mobilele.domain.dtos.view.UserRoleViewDTO;
import com.softuni.mobilele.services.role.UserRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    private final UserRoleService userRoleService;

    public UserController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @GetMapping("/register")
    public ModelAndView getRegister(ModelAndView modelAndView){
        List<UserRoleViewDTO> roleViewDTOS = this.userRoleService.getAll();
        modelAndView.addObject("roles", roleViewDTOS);
        return super.view("auth-register", modelAndView);
    }

    @PostMapping("/register")
    public ModelAndView postRegister(UserRegisterFormDTO userRegister){
        return super.redirect("auth-login");
    }
}
