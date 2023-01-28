package com.softuni.mobilele.services.init;

import com.softuni.mobilele.services.role.UserRoleService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatabaseInitServiceImpl implements DatabaseInitService {

    private final UserRoleService userRoleService;

    @Autowired
    public DatabaseInitServiceImpl(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostConstruct
    public void postConStruct(){
        dbInit();
    }

    @Override
    public void dbInit() {
        if (isDbInit()) {
            this.userRoleService.dbInit();
        }
    }

    @Override
    public boolean isDbInit() {
        return this.userRoleService.isDbInit();
    }
}



