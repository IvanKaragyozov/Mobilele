package com.softuni.mobilele.domain.dtos.models;

import com.softuni.mobilele.domain.entities.Brand;
import com.softuni.mobilele.domain.enums.ModelCategory;

import java.util.Date;

public class ModelDTO {

    private String name;

    private ModelCategory category;

    private String imageUrl;

    private Integer startYear;

    private Integer endYear;

    private Date created;

    private Date modified;

    private Brand brand;


    public String getName() {
        return name;
    }

    public ModelDTO setName(String name) {
        this.name = name;
        return this;
    }

    public ModelCategory getCategory() {
        return category;
    }

    public ModelDTO setCategory(ModelCategory category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getStartYear() {
        return startYear;
    }

    public ModelDTO setStartYear(Integer startYear) {
        this.startYear = startYear;
        return this;
    }

    public Integer getEndYear() {
        return endYear;
    }

    public ModelDTO setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public ModelDTO setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getModified() {
        return modified;
    }

    public ModelDTO setModified(Date modified) {
        this.modified = modified;
        return this;
    }

    public Brand getBrand() {
        return brand;
    }

    public ModelDTO setBrand(Brand brand) {
        this.brand = brand;
        return this;
    }
}
