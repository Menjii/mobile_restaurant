package pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import pl.pwsztar.mobilerestaurant.RestaurantApplication;
import pl.pwsztar.mobilerestaurant.model.api.services.FoodService;
import pl.pwsztar.mobilerestaurant.model.dtos.FoodDto;

public class CategoryViewModel extends Observable {
    private Context context;
    private int categoryId;
    private List<FoodDto> foodDtoList;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public CategoryViewModel(@NonNull Context context, int categoryId) {
        this.categoryId = categoryId;
        this.context = context;
        this.foodDtoList = new ArrayList<>();
        refresh();
    }

    public void refresh() {
        fetchAllFoods();
    }

    private void fetchAllFoods() {
        RestaurantApplication application = RestaurantApplication.create(context);
        FoodService foodService = new FoodService();

        Disposable disposable = foodService.getById(context, categoryId)
                .subscribeOn(application.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    foodDtoList = response;
                    notifyFoodsDataChanged();
                    Log.i("TEST", String.valueOf(foodDtoList.size()));
                }, throwable -> {
                    Log.e("TEST", "TODO1: On Error Message" + throwable.toString());
                    throwable.printStackTrace();
                });

        compositeDisposable.add(disposable);
    }

    private void notifyFoodsDataChanged() {
        setChanged();
        notifyObservers();
    }

    public List<FoodDto> getFoodDtoList() {
        return foodDtoList;
    }

    public void reset() {
        compositeDisposable.dispose();
        compositeDisposable = null;
        context = null;
    }
}
