package com.softuni.mobilele.services.user;

import com.softuni.mobilele.domain.beans.LoggedUser;
import com.softuni.mobilele.domain.dtos.binding.UserLoginFormDTO;
import com.softuni.mobilele.domain.dtos.binding.UserRegisterFormDTO;
import com.softuni.mobilele.domain.dtos.models.UserModel;
import com.softuni.mobilele.domain.entities.User;
import com.softuni.mobilele.repositories.UserRepository;
import com.softuni.mobilele.services.init.DatabaseInitService;
import com.softuni.mobilele.services.role.UserRoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService, DatabaseInitService {

    private final UserRepository userRepository;
    private final UserRoleService userRoleService;
    private final ModelMapper modelMapper;
    private final LoggedUser loggedUser;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserRoleService userRoleService, ModelMapper modelMapper, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.userRoleService = userRoleService;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
    }

    @Override
    public void dbInit() {

    }

    @Override
    public boolean isDbInit() {
        return false;
    }

    @Override
    public UserModel registerUser(UserRegisterFormDTO userRegister){
        UserModel userModel = this.modelMapper.map(userRegister, UserModel.class);

        userModel.setRoles(this.userRepository.count() == 0
                ? userRoleService.findAllRoles()
                : List.of(this.userRoleService.findRoleByName("USER")));

        User userToSave = this.modelMapper.map(userModel, User.class);

        return this.modelMapper.map(this.userRepository.saveAndFlush(userToSave), UserModel.class);
    }

    @Override
    public void loginUser(UserLoginFormDTO userLogin) {
        UserModel loginCandidate =
                this.modelMapper.map(this.userRepository.findByUsername(userLogin.getUsername()).get(), UserModel.class);

        this.loggedUser
                .setId(loginCandidate.getId())
                .setUsername(loginCandidate.getUsername())
                .setRoleModels(loginCandidate.getRoles());
    }

    @Override
    public void logout(){
        this.loggedUser.clearUserData();
    }

}

