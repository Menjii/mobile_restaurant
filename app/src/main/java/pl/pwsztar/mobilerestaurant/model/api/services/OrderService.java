package pl.pwsztar.mobilerestaurant.model.api.services;

import java.util.List;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.api.RestProvider;
import pl.pwsztar.mobilerestaurant.model.dtos.FoodDto;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderDataDto;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderDto;

public class OrderService {
    public Observable<List<OrderDataDto>> getAllUserOrders(int id) {
        return RestProvider.getInstance().getOrderApi().fetchAllUserOrders(id);
    }

    public Observable<OrderDto> getOrderObject(OrderDto order) {
        return RestProvider.getInstance().getOrderApi().getOrderObject(order);
    }
}
