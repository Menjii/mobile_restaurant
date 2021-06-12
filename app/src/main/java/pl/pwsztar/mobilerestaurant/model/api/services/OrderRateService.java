package pl.pwsztar.mobilerestaurant.model.api.services;

import android.content.Context;

import java.util.List;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.api.RestProvider;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderDataDto;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderRateDto;

public class OrderRateService {
    public Observable<OrderRateDto> getOrderRateObject(Context context, OrderRateDto orderRate) {
        return RestProvider.getInstance(context).getOrderRateApi().getOrderRateObject(orderRate);
    }
}
