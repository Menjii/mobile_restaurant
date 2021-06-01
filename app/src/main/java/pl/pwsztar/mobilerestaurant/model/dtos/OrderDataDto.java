package pl.pwsztar.mobilerestaurant.model.dtos;

import java.util.List;

public class OrderDataDto {
    OrderDto order;
    List<ProductDto> products;

    public OrderDataDto(OrderDto order, List<ProductDto> products) {
        this.order = order;
        this.products = products;
    }

    public OrderDto getOrder() {
        return order;
    }

    public List<ProductDto> getProducts() {
        return products;
    }
}
