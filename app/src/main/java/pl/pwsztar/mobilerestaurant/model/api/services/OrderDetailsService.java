package pl.pwsztar.mobilerestaurant.model.api.services;

import android.content.Context;

import java.util.List;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.api.RestProvider;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderRateDto;
import pl.pwsztar.mobilerestaurant.model.dtos.ProductDto;

public class OrderDetailsService {
    public Observable<List<ProductDto>> saveOrder(Context context, List<ProductDto> products) {
        return RestProvider.getInstance(context).getOrderDetailsApi().saveOrder(products);
    }
}
