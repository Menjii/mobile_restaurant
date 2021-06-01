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

    @SerializedName("imageHref")
    @Expose
    String imageHref;

    @SerializedName("prize")
    @Expose
    int price;

    public FoodDto(int id, CategoryDto category, String name, String description, String imageHref, int price) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.description = description;
        this.imageHref = imageHref;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public CategoryDto getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageHref() {
        return imageHref;
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
