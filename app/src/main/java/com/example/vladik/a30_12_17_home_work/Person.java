package com.example.vladik.a30_12_17_home_work;

/**
 * Created by vladik on 31/12/2017.
 */

public class Person {
    private String name, phone, description, email;

    public Person() {
    }

    public Person(String name, String phone, String email, String description) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
