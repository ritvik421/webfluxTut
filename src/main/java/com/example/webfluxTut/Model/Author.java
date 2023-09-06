package com.example.webfluxTut.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
@Document(collection = "author")
public class Author {

    @Id
    private String id ;
    @NotBlank(message = "Name cannot be blank")
    @NotNull(message = "Name cannot be null")

    @Field("name")
    private String name ;

    @Field
    private Address address ;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Author(String id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
