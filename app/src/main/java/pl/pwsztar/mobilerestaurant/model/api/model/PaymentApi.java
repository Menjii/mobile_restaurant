package pl.pwsztar.mobilerestaurant.model.api.model;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderRateDto;
import pl.pwsztar.mobilerestaurant.model.dtos.PaymentDto;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PaymentApi {
    @POST("restaurant/payment")
    Observable<PaymentDto> getPaymentObject(@Body PaymentDto payment);
}
