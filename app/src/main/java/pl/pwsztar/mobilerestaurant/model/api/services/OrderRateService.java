package pl.pwsztar.mobilerestaurant.model.api.services;

import java.util.List;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.api.RestProvider;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderDataDto;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderRateDto;

public class OrderRateService {
    public Observable<OrderRateDto> getOrderRateObject(OrderRateDto orderRate) {
        return RestProvider.getInstance().getOrderRateApi().getOrderRateObject(orderRate);
    }
}
