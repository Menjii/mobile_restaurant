package pl.pwsztar.mobilerestaurant.model.api.model;

import java.util.List;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.dtos.FoodDto;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderDataDto;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderDto;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderRateDto;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface OrderApi {
    @GET("restaurant/orders/user")
    Observable<List<OrderDataDto>> fetchAllUserOrders(@Query("id") int id);

    @POST("restaurant/order")
    Observable<OrderDto> getOrderObject(@Body OrderDto order);
}
