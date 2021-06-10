package pl.pwsztar.mobilerestaurant.model.dtos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private int id;
    private String username;
    private String email;
    private String phone;
    private String name;
    private String surname;
    private String password;
    private AddressDto address;

    public User(LoginResponse loginResponse ) {
        this.id = loginResponse.getId();
        this.email = loginResponse.getEmail();
        this.phone = loginResponse.getPhone();
        this.name = loginResponse.getName();
        this.surname = loginResponse.getSurname();
        this.password = "";
        this.address = loginResponse.getAddressDto();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(AddressDto address) {
        this.address = address;
    }

}
