package pl.pwsztar.mobilerestaurant.model.api.model;

import java.util.List;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.dtos.FoodDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface FoodApi {
    @GET("restaurant/food")
    Observable<List<FoodDto>> fetchAllFoods();

    @GET("restaurant/foodByCategory")
    Observable<List<FoodDto>> fetchFoodsByCategoryId(@Query("categoryId") int categoryId);
}
