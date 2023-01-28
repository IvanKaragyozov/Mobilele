package com.softuni.mobilele.domain.dtos.models;


public class BaseEntityDTO {

    private String id;

    public BaseEntityDTO() {
    }

    public String getId() {
        return id;
    }

    public BaseEntityDTO setId(String id) {
        this.id = id;
        return this;
    }
}
