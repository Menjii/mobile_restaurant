package pl.pwsztar.mobilerestaurant.model.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddressDto {
    int id;
    String street;
    String homeNumber;
    String city;
    String postNumber;
}
