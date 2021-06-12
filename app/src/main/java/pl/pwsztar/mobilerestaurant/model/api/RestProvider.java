package pl.pwsztar.mobilerestaurant.model.api;

import android.content.Context;

import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.model.api.model.AuthApi;
import pl.pwsztar.mobilerestaurant.model.api.model.FoodApi;
import pl.pwsztar.mobilerestaurant.model.api.model.OrderApi;
import pl.pwsztar.mobilerestaurant.model.api.model.OrderDetailsApi;
import pl.pwsztar.mobilerestaurant.model.api.model.OrderRateApi;
import pl.pwsztar.mobilerestaurant.model.api.model.PaymentApi;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestProvider {
    private FoodApi foodApi;
    private AuthApi authApi;
    private OrderApi orderApi;
    private OrderRateApi orderRateApi;
    private PaymentApi paymentApi;
    private OrderDetailsApi orderDetailsApi;

    RestProvider(Context context) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://"+context.getResources().getString(R.string.server_ip)+"/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        foodApi = retrofit.create(FoodApi.class);
        authApi = retrofit.create(AuthApi.class);
        orderApi = retrofit.create(OrderApi.class);
        orderRateApi = retrofit.create(OrderRateApi.class);
        paymentApi = retrofit.create(PaymentApi.class);
        orderDetailsApi = retrofit.create(OrderDetailsApi.class);
    }

    public static RestProvider getInstance(Context context) {
        return new RestProvider(context);
    }

    public FoodApi getFoodApi() {
        return foodApi;
    }
    public AuthApi getAuthApi() {
        return authApi;
    }

    public OrderApi getOrderApi() {
        return orderApi;
    }

    public OrderRateApi getOrderRateApi() {
        return orderRateApi;
    }

    public PaymentApi getPaymentApi() {
        return paymentApi;
    }

    public OrderDetailsApi getOrderDetailsApi() {
        return orderDetailsApi;
    }
}
