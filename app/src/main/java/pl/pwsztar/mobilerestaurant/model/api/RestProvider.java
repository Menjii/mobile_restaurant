package pl.pwsztar.mobilerestaurant.model.api;

import pl.pwsztar.mobilerestaurant.model.api.model.FoodApi;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestProvider {
    private FoodApi foodApi;

    RestProvider() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.42.89:8080/api/restaurant/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        foodApi = retrofit.create(FoodApi.class);
    }

    public static RestProvider getInstance() {
        return new RestProvider();
    }

    public FoodApi getFoodApi() {
        return foodApi;
    }
}
