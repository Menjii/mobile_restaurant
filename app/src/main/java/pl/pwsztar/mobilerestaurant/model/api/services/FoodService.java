package pl.pwsztar.mobilerestaurant.model.api.services;

import android.content.Context;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.api.RestProvider;
import pl.pwsztar.mobilerestaurant.model.api.model.FoodApi;
import pl.pwsztar.mobilerestaurant.model.dtos.FoodDto;
import retrofit2.Retrofit;

public class FoodService {
    public Observable<List<FoodDto>> getAll(Context context) {
        return RestProvider.getInstance(context).getFoodApi().fetchAllFoods();
    }

    public Observable<List<FoodDto>> getById(Context context, int id) {
        return RestProvider.getInstance(context).getFoodApi().fetchFoodsByCategoryId(id);
    }
}
