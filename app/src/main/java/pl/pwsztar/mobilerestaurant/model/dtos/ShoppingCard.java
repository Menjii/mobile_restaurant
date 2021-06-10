package pl.pwsztar.mobilerestaurant.model.dtos;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCard {
    List<ProductDto> items;

    public ShoppingCard() {
        items = new ArrayList<>();
    }

    public ShoppingCard(List<ProductDto> items) {
        this.items = items;
    }

    public List<ProductDto> getItems() {
        return items;
    }
}
