package pl.pwsztar.mobilerestaurant.model.dtos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FoodDto {
    @SerializedName("id")
    @Expose
    int id;

    @SerializedName("categoryDto")
    @Expose
    CategoryDto category;

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("description")
    @Expose
    String description;

    @SerializedName("prize")
    @Expose
    int price;

    public FoodDto(int id, CategoryDto category, String name, String description, int price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public CategoryDto getCategoryId() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "FoodDto{" +
                "id=" + id +
                ", categoryId=" + category.toString() +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
