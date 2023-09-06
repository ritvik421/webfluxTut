package com.example.webfluxTut.Model;

import org.springframework.data.mongodb.core.mapping.Field;

public class Address {
    @Field
    private String houseNo;
    @Field
    private String city;

    @Field
    private String state ;

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Address(String houseNo, String city, String state) {
        this.houseNo = houseNo;
        this.city = city;
        this.state = state;
    }
}
