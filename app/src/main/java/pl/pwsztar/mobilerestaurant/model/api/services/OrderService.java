package pl.pwsztar.mobilerestaurant.model.api.services;

import android.content.Context;

import java.util.List;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.api.RestProvider;
import pl.pwsztar.mobilerestaurant.model.dtos.FoodDto;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderDataDto;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderDto;

public class OrderService {
    public Observable<List<OrderDataDto>> getAllUserOrders(Context context, int id) {
        return RestProvider.getInstance(context).getOrderApi().fetchAllUserOrders(id);
    }

    public Observable<OrderDto> getOrderObject(Context context, OrderDto order) {
        return RestProvider.getInstance(context).getOrderApi().getOrderObject(order);
    }
}
