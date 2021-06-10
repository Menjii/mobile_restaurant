package pl.pwsztar.mobilerestaurant.views.activity.ShoppingCardActivity;

import android.content.Context;

import androidx.annotation.NonNull;

import java.util.List;
import java.util.Observable;

import io.reactivex.disposables.CompositeDisposable;
import pl.pwsztar.mobilerestaurant.model.dtos.FoodDto;
import pl.pwsztar.mobilerestaurant.model.dtos.ProductDto;
import pl.pwsztar.mobilerestaurant.utils.ShoppingCardUtils;

public class ShoppingCardActivityViewModel extends Observable {
    private Context context;
    public List<ProductDto> shoppingCardItems;
    public int prizeInt = 0;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public ShoppingCardActivityViewModel(@NonNull Context context) {

        this.context = context;
        refresh();
    }

    private void refresh() {
        this.prizeInt = 0;
        this.shoppingCardItems = ShoppingCardUtils.getItems(context).getItems();
        for( ProductDto product : this.shoppingCardItems) {
            prizeInt += product.getCount() * product.getFood().getPrice();
        }
    }

    public void onAddItem(FoodDto item) {
        ShoppingCardUtils.addItem(context, item);
        refresh();
        notifyFoodsDataChanged();
    }

    public void onRemoveItem(FoodDto item) {
        ShoppingCardUtils.removeItem(context, item);
        refresh();
        notifyFoodsDataChanged();
    }

    private void notifyFoodsDataChanged() {
        setChanged();
        notifyObservers();
    }

    public void reset() {
        compositeDisposable.dispose();
        compositeDisposable = null;
        context = null;
    }
}
