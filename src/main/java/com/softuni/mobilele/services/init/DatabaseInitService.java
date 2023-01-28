package com.softuni.mobilele.services.init;

import org.springframework.stereotype.Service;

@Service
public interface DatabaseInitService {

    void dbInit();

    boolean isDbInit();

}
