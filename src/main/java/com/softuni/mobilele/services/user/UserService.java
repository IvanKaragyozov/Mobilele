package com.softuni.mobilele.services.user;

import com.softuni.mobilele.domain.dtos.binding.UserLoginFormDTO;
import com.softuni.mobilele.domain.dtos.binding.UserRegisterFormDTO;
import com.softuni.mobilele.domain.dtos.models.UserModel;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    UserModel registerUser(UserRegisterFormDTO userRegister);

    void loginUser(UserLoginFormDTO userLogin);

    void logout();
}
