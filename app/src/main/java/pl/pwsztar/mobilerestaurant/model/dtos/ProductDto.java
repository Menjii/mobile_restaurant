package pl.pwsztar.mobilerestaurant.model.dtos;

public class ProductDto {
    private int id;
    private FoodDto food;
    private OrderDto order;
    private int count = 1;

    public ProductDto() {
    }

    public ProductDto(int id, FoodDto food, int count) {
        this.id = id;
        this.food = food;
        this.count = count;
    }

    public ProductDto(int id, FoodDto food, OrderDto order, int count) {
        this.id = id;
        this.food = food;
        this.order = order;
        this.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderDto getOrder() {
        return order;
    }

    public void setOrder(OrderDto order) {
        this.order = order;
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

    public void setCount(int count) {
        this.count = count;
    }

    public void setFood(FoodDto food) {
        this.food = food;
    }
}
