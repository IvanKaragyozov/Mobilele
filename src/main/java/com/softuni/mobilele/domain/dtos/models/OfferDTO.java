package com.softuni.mobilele.domain.dtos.models;

import com.softuni.mobilele.domain.entities.Model;
import com.softuni.mobilele.domain.entities.User;
import com.softuni.mobilele.domain.enums.Engine;
import com.softuni.mobilele.domain.enums.Transmission;

import java.util.Date;

public class OfferDTO {

    private String description;

    private Engine engine;

    private String imageUrl;

    private String mileage;

    private String price;

    private Transmission transmission;

    private Integer year;

    private Date created;

    private Date modified;

    private Model model;

    private User seller;

    public String getDescription() {
        return description;
    }

    public OfferDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public OfferDTO setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public OfferDTO setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public String getMileage() {
        return mileage;
    }

    public OfferDTO setMileage(String mileage) {
        this.mileage = mileage;
        return this;
    }

    public String getPrice() {
        return price;
    }

    public OfferDTO setPrice(String price) {
        this.price = price;
        return this;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public OfferDTO setTransmission(Transmission transmission) {
        this.transmission = transmission;
        return this;
    }

    public Integer getYear() {
        return year;
    }

    public OfferDTO setYear(Integer year) {
        this.year = year;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public OfferDTO setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getModified() {
        return modified;
    }

    public OfferDTO setModified(Date modified) {
        this.modified = modified;
        return this;
    }

    public Model getModel() {
        return model;
    }

    public OfferDTO setModel(Model model) {
        this.model = model;
        return this;
    }

    public User getSeller() {
        return seller;
    }

    public OfferDTO setSeller(User seller) {
        this.seller = seller;
        return this;
    }
}
