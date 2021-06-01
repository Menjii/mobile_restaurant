package pl.pwsztar.mobilerestaurant.views.activity.LoginActivity;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import pl.pwsztar.mobilerestaurant.RestaurantApplication;
import pl.pwsztar.mobilerestaurant.model.api.services.AuthService;
import pl.pwsztar.mobilerestaurant.model.dtos.FoodDto;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginRequest;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;
import pl.pwsztar.mobilerestaurant.utils.UserModelUtils;

import static android.content.Context.MODE_PRIVATE;

public class LoginActivityViewModel extends Observable {
    private Activity context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    public LoginResponse loginResponse;

    public LoginActivityViewModel(@NonNull Activity context) {
        this.context = context;
    }

    public void login(LoginRequest authData) {
        RestaurantApplication application = new RestaurantApplication();
        AuthService authService = new AuthService();

        Disposable disposable = authService.login(authData)
                .subscribeOn(application.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    this.loginResponse = response;
                    notifyFoodsDataChanged();
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


    public void reset() {
        compositeDisposable.dispose();
        compositeDisposable = null;
        context = null;
    }
}
