package com.media.focus.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

@Data
public class Customer {

    private String name;
    private String email;
    private String internationalPhoneNumber;

    private boolean isAgree;


    public Customer(String json) {
        Gson gson = new Gson();
        Customer request = gson.fromJson(json, Customer.class);
        this.internationalPhoneNumber  = request.getInternationalPhoneNumber();
        this.name = request.getName();
        this.email = request.getEmail();
        this.isAgree = request.isAgree();
    }

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }

}