package pl.pwsztar.mobilerestaurant.model.api;

import pl.pwsztar.mobilerestaurant.model.api.model.AuthApi;
import pl.pwsztar.mobilerestaurant.model.api.model.FoodApi;
import pl.pwsztar.mobilerestaurant.model.api.model.OrderApi;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestProvider {
    private FoodApi foodApi;
    private AuthApi authApi;
    private OrderApi orderApi;

    RestProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.42.72:8001/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        foodApi = retrofit.create(FoodApi.class);
        authApi = retrofit.create(AuthApi.class);
        orderApi = retrofit.create(OrderApi.class);
    }

    public static RestProvider getInstance() {
        return new RestProvider();
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
}
