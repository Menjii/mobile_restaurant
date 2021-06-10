package pl.pwsztar.mobilerestaurant.model.api.model;

import java.util.List;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderRateDto;
import pl.pwsztar.mobilerestaurant.model.dtos.ProductDto;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface OrderDetailsApi {
    @POST("restaurant/order-data/all")
    Observable<List<ProductDto>> saveOrder(@Body List<ProductDto> products);
}
