package pl.pwsztar.mobilerestaurant.model.api.services;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.api.RestProvider;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderRateDto;
import pl.pwsztar.mobilerestaurant.model.dtos.PaymentDto;

public class PaymentService {
    public Observable<PaymentDto> getPaymentObject(PaymentDto payment) {
        return RestProvider.getInstance().getPaymentApi().getPaymentObject(payment);
    }
}
