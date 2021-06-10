package pl.pwsztar.mobilerestaurant.views.activity.CreateOrderActivity;

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
import pl.pwsztar.mobilerestaurant.model.api.services.OrderDetailsService;
import pl.pwsztar.mobilerestaurant.model.api.services.OrderRateService;
import pl.pwsztar.mobilerestaurant.model.api.services.OrderService;
import pl.pwsztar.mobilerestaurant.model.api.services.PaymentService;
import pl.pwsztar.mobilerestaurant.model.dtos.FoodDto;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderDto;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderRateDto;
import pl.pwsztar.mobilerestaurant.model.dtos.PaymentDto;
import pl.pwsztar.mobilerestaurant.model.dtos.ProductDto;
import pl.pwsztar.mobilerestaurant.model.dtos.User;
import pl.pwsztar.mobilerestaurant.utils.ShoppingCardUtils;
import pl.pwsztar.mobilerestaurant.utils.UserModelUtils;

public class CreateOrderActivityViewModel extends Observable {
    private Context context;
    public List<ProductDto> shoppingCardItems;
    public int prizeInt = 0;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();


    private PaymentDto paymentDto = new PaymentDto(null, prizeInt, "MOBILE", "10.06.2021", "10.06.2021");
    private OrderRateDto orderRateDto = new OrderRateDto(null, 0, "");
    private OrderDto orderDto;
    public CreateOrderActivityViewModel(@NonNull Context context) {

        this.context = context;
        refresh();
        getPaymentObject();
    }

    private void refresh() {
        this.prizeInt = 0;
        this.shoppingCardItems = ShoppingCardUtils.getItems(context).getItems();
        for( ProductDto product : this.shoppingCardItems) {
            prizeInt += product.getCount() * product.getFood().getPrice();
        }
    }

    private void getPaymentObject() {
        RestaurantApplication application = RestaurantApplication.create(context);
        PaymentService paymentService = new PaymentService();
        Disposable disposable = paymentService.getPaymentObject(paymentDto)
                .subscribeOn(application.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    paymentDto = response;
                    Log.e("TEST", "Success getPaymentObject");
                    getOrderRateObject();
                }, throwable -> {
                    Log.e("TEST", "Error getPaymentObject");
                    Log.e("TEST", "TODO1: On Error Message" + throwable.toString());
                    throwable.printStackTrace();
                });

        compositeDisposable.add(disposable);
    }

    private void getOrderRateObject() {
        RestaurantApplication application = RestaurantApplication.create(context);
        OrderRateService orderRateService = new OrderRateService();
        Disposable disposable = orderRateService.getOrderRateObject(orderRateDto)
                .subscribeOn(application.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    orderRateDto = response;
                    Log.e("TEST", "Success getOrderRateObject");
                    getOrderObject();
                }, throwable -> {
                    Log.e("TEST", "Error getOrderRateObject");
                    Log.e("TEST", "TODO1: On Error Message" + throwable.toString());
                    throwable.printStackTrace();
                });

        compositeDisposable.add(disposable);
    }

    private void getOrderObject() {
        LoginResponse currentUser = UserModelUtils.getUser(context);
        orderDto = new OrderDto(null, new User(currentUser), orderRateDto, paymentDto, "ZAPŁACONE", "");

        RestaurantApplication application = RestaurantApplication.create(context);
        OrderService orderService = new OrderService();
        Disposable disposable = orderService.getOrderObject(orderDto)
                .subscribeOn(application.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    orderDto = response;
                    Log.e("TEST", "Success getOrderObject");
                    saveProducts();
                }, throwable -> {
                    Log.e("TEST", "Error getOrderObject");
                    Log.e("TEST", "TODO1: On Error Message" + throwable.toString());
                    throwable.printStackTrace();
                });

        compositeDisposable.add(disposable);
    }

    private void saveProducts() {
        List<ProductDto> productList = new ArrayList<>();
        for( ProductDto product : shoppingCardItems) {
            product.setOrder(orderDto);
            productList.add(product);
        }
        Log.e("TEST", String.valueOf(productList.size()));
        Log.e("TEST", productList.toString());

        RestaurantApplication application = RestaurantApplication.create(context);
        OrderDetailsService orderDetailsService = new OrderDetailsService();
        Disposable disposable = orderDetailsService.saveOrder(shoppingCardItems)
                .subscribeOn(application.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    shoppingCardItems = response;
                    Log.e("TEST", "Success saveProducts");
                    notifyFoodsDataChanged();
                }, throwable -> {
                    Log.e("TEST", "Error saveProducts");
                    Log.e("TEST", "TODO1: On Error Message" + throwable.toString());
                    throwable.printStackTrace();
                });

        compositeDisposable.add(disposable);
    }

    private void notifyFoodsDataChanged() {
        Log.e("TEST", "Success END");
        ShoppingCardUtils.clear(context);
        setChanged();
        notifyObservers();
    }

    public void reset() {
        compositeDisposable.dispose();
        compositeDisposable = null;
        context = null;
    }
}
