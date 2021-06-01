package pl.pwsztar.mobilerestaurant.model.api.services;

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
    public Observable<List<FoodDto>> getAll() {
        return RestProvider.getInstance().getFoodApi().fetchAllFoods();
    }

    public Observable<List<FoodDto>> getById(int id) {
        return RestProvider.getInstance().getFoodApi().fetchFoodsByCategoryId(id);
    }
}
