package pl.pwsztar.mobilerestaurant.model.api.services;

import java.util.List;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.api.RestProvider;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderRateDto;
import pl.pwsztar.mobilerestaurant.model.dtos.ProductDto;

public class OrderDetailsService {
    public Observable<List<ProductDto>> saveOrder(List<ProductDto> products) {
        return RestProvider.getInstance().getOrderDetailsApi().saveOrder(products);
    }
}
