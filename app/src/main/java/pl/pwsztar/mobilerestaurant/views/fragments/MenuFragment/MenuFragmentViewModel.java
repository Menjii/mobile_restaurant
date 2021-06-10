package pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

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
import pl.pwsztar.mobilerestaurant.model.dtos.ProductDto;
import pl.pwsztar.mobilerestaurant.utils.ShoppingCardUtils;

public class MenuFragmentViewModel extends Observable {
    private Context context;
    public int itemsInStore = 1;

    public MenuFragmentViewModel(Context context) {
        this.context = context;
        this.itemsInStore = ShoppingCardUtils.getSize(context);
    }

    public void addNewItemToStore(FoodDto foodDto) {
        itemsInStore += 1;
        ShoppingCardUtils.addItem(context, foodDto);
        notifyFoodsDataChanged();
    }

    private void notifyFoodsDataChanged() {
        setChanged();
        notifyObservers();
    }

}
