package com.softuni.mobilele.demo;

import com.softuni.mobilele.domain.dtos.binding.UserRegisterFormDTO;
import com.softuni.mobilele.web.BaseController;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/demo")
public class StateController extends BaseController {

    private static final String STATE_USERNAME_KEY = "username";

    @GetMapping("/register")
    public ModelAndView getRegister(){
        return super.view("demo/register");
    }

    @PostMapping("/registerTestMe")
    public ModelAndView postRegister(HttpServletResponse response,
                                     @RequestParam(name = STATE_USERNAME_KEY) String username){

        Cookie cookie = new Cookie(STATE_USERNAME_KEY, username);
        response.addCookie(cookie);

        return super.redirect("/login");
    }

    @PostMapping("/register")
    public ModelAndView postRegister(UserRegisterFormDTO userRegisterForm, HttpSession httpSession){

        httpSession.setAttribute(STATE_USERNAME_KEY, userRegisterForm.getUsername());
        return super.redirect("/demo/login");
    }

    @GetMapping("/loginTestMe")
    public ModelAndView getLogin(ModelAndView modelAndView,
                                 @CookieValue(name = STATE_USERNAME_KEY,
                                 defaultValue = "") String username) {

        modelAndView.addObject(STATE_USERNAME_KEY, username);
        return super.view("demo/login", modelAndView);
    }

    @GetMapping("/login")
    public ModelAndView getLogin2(ModelAndView modelAndView, HttpSession httpSession){

        String fetchedUsername = httpSession.getAttribute(STATE_USERNAME_KEY).toString();

        modelAndView.addObject(STATE_USERNAME_KEY, fetchedUsername);

        return super.view("demo/login", modelAndView);
    }

}
