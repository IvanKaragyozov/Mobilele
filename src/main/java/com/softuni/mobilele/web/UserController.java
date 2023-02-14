package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.dtos.binding.UserLoginFormDTO;
import com.softuni.mobilele.domain.dtos.binding.UserRegisterFormDTO;
import com.softuni.mobilele.domain.dtos.models.UserModel;
import com.softuni.mobilele.domain.dtos.views.UserRoleViewDTO;
import com.softuni.mobilele.services.role.UserRoleService;
import com.softuni.mobilele.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController extends BaseController {

    public static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";

    private final UserRoleService userRoleService;
    private final UserService userService;

    public UserController(UserRoleService userRoleService, UserService userService) {
        this.userRoleService = userRoleService;
        this.userService = userService;
    }

    // HTTP Mappings

    @GetMapping("/register")
    public String getRegister(Model model){
        return "auth-register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute(name = "userRegisterForm") UserRegisterFormDTO userRegisterInfo,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRegisterForm", userRegisterInfo)
                    .addFlashAttribute(BINDING_RESULT_PATH + "userRegisterForm", bindingResult);

            return "redirect:register";
        }
        this.userService.registerUser(userRegisterInfo);
        return "redirect:login";
    }

    @GetMapping("/login")
    public ModelAndView getLogin(){
        return super.view("auth-login");
    }

    @PostMapping("/login")
    public ModelAndView postLogin(@Valid @ModelAttribute(name = "userLoginForm") UserLoginFormDTO userLoginForm,
                                  BindingResult bindingResult,
                                  ModelAndView modelAndView){

        if (bindingResult.hasErrors()) {
            return super.view("auth-login",
                    modelAndView.addObject("userLoginForm", userLoginForm));
        }

        return super.redirect("/");
    }

    @PostMapping("/logout")
    public ModelAndView postLogout(){
        this.userService.logout();
        return super.redirect("/");
    }

    // Model mappings

    @ModelAttribute(name = "userRegisterForm")
    public UserRegisterFormDTO initUserRegisterFormDTO(){
        return new UserRegisterFormDTO();
    }

    @ModelAttribute(name = "userLoginForm")
    public UserLoginFormDTO initUserLoginFormDTO(){
        return new UserLoginFormDTO();
    }

    @ModelAttribute(name = "roles")
    public List<UserRoleViewDTO> getAllUserRoleViews(){
        return this.userRoleService.getAllUserRoleViews();
    }

}
