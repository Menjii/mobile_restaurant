package pl.pwsztar.mobilerestaurant.model.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginResponse {
    @SerializedName("id")
    @Expose
    int id;

    @SerializedName("username")
    @Expose
    String username;

    @SerializedName("email")
    @Expose
    String email;

    @SerializedName("phone")
    @Expose
    String phone;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("surname")
    @Expose
    String surname;

    @SerializedName("address")
    @Expose
    AddressDto addressDto;

    @SerializedName("roles")
    @Expose
    List<String> roles;

    @SerializedName("accessToken")
    @Expose
    String accessToken;

    @SerializedName("tokenType")
    @Expose
    String tokenType;

    public LoginResponse(int id, String username, String email, String phone, String name, String surname, AddressDto addressDto, List<String> roles, String accessToken, String tokenType) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.name = name;
        this.surname = surname;
        this.addressDto = addressDto;
        this.roles = roles;
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public AddressDto getAddressDto() {
        return addressDto;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", addressDto=" + addressDto +
                ", roles=" + roles +
                ", accessToken='" + accessToken + '\'' +
                ", tokenType='" + tokenType + '\'' +
                '}';
    }
}
