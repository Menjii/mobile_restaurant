package pl.pwsztar.mobilerestaurant.model.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CategoryDto {
    @SerializedName("id")
    @Expose
    int id;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("desc")
    @Expose
    String description;

    public CategoryDto(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
