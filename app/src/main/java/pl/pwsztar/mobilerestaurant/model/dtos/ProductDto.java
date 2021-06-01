package pl.pwsztar.mobilerestaurant.model.dtos;

public class ProductDto {
    private int id;
    private FoodDto food;
    private int count;

    public ProductDto(int id, FoodDto food, int count) {
        this.id = id;
        this.food = food;
        this.count = count;
    }

    public int getId() {
        return id;
    }

    public FoodDto getFood() {
        return food;
    }

    public int getCount() {
        return count;
    }
}
