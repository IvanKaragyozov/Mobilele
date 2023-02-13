package com.softuni.mobilele.services.role;

import com.softuni.mobilele.domain.dtos.models.UserRoleModel;
import com.softuni.mobilele.domain.dtos.views.UserRoleViewDTO;
import com.softuni.mobilele.domain.entities.UserRole;
import com.softuni.mobilele.domain.enums.Role;
import com.softuni.mobilele.repositories.UserRoleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public UserRoleServiceImpl(UserRoleRepository userRoleRepository, ModelMapper modelMapper) {
        this.userRoleRepository = userRoleRepository;
        this.modelMapper = modelMapper;
        this.dbInit();
    }

    @Override
    public void dbInit() {
        if (!isDbInit()) {
            List<UserRole> roles = new ArrayList<>();
            roles.add(new UserRole().setRole(Role.USER));
            roles.add(new UserRole().setRole(Role.ADMIN));

            this.userRoleRepository.saveAllAndFlush(roles);
        }
    }

    @Override
    public boolean isDbInit() {
        return this.userRoleRepository.count() > 0;
    }

    public List<UserRoleViewDTO> getAll(){
       return this.userRoleRepository
                .findAll()
                .stream()
                .map(role -> this.modelMapper.map(role, UserRoleViewDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserRoleModel> findAllRoles(){
        return this.userRoleRepository
                .findAll()
                .stream()
                .map(role -> this.modelMapper.map(role, UserRoleModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserRoleModel findRoleByName(String name){
        return this.modelMapper.map(this.userRoleRepository
                .findByRole(name)
                .orElseThrow(NoSuchElementException::new), UserRoleModel.class);
    }
}

