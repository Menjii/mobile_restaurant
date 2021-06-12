package pl.pwsztar.mobilerestaurant.views.fragments.OrderFragment;

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
import pl.pwsztar.mobilerestaurant.model.api.services.OrderService;
import pl.pwsztar.mobilerestaurant.model.dtos.FoodDto;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderDataDto;
import pl.pwsztar.mobilerestaurant.utils.UserModelUtils;

public class OrderFragmentViewModel extends Observable {
    private Context context;
    private List<OrderDataDto> orderList;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public OrderFragmentViewModel(@NonNull Context context) {

        this.context = context;
        this.orderList = new ArrayList<>();
        refresh();
    }

    public void refresh() {
        fetchUserOrders();
    }

    private void fetchUserOrders() {
        RestaurantApplication application = RestaurantApplication.create(context);
        OrderService orderService = new OrderService();

        Disposable disposable = orderService.getAllUserOrders(context, UserModelUtils.getUser(context).getId())
                .subscribeOn(application.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    orderList = response;
                    notifyFoodsDataChanged();
                }, Throwable::printStackTrace);

        compositeDisposable.add(disposable);
    }

    private void notifyFoodsDataChanged() {
        setChanged();
        notifyObservers();
    }

    public List<OrderDataDto> getOrderList() {
        return orderList;
    }

    public void reset() {
        compositeDisposable.dispose();
        compositeDisposable = null;
        context = null;
    }
}
