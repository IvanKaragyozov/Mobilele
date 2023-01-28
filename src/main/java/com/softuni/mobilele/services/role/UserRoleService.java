package com.softuni.mobilele.services.role;

import com.softuni.mobilele.domain.dtos.view.UserRoleViewDTO;
import com.softuni.mobilele.services.init.DatabaseInitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRoleService extends DatabaseInitService {

    List<UserRoleViewDTO> getAll();

}
