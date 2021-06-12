package pl.pwsztar.mobilerestaurant.views.activity.RegisterActivity;

import android.app.Activity;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import pl.pwsztar.mobilerestaurant.RestaurantApplication;
import pl.pwsztar.mobilerestaurant.model.api.services.AuthService;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginRequest;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;
import pl.pwsztar.mobilerestaurant.model.dtos.SignUpRequest;

public class RegisterActivityViewModel extends Observable {
    private Activity context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    public SignUpRequest loginResponse;

    public RegisterActivityViewModel(@NonNull Activity context) {
        this.context = context;
    }

    public void register(SignUpRequest authData) {
        RestaurantApplication application = new RestaurantApplication();
        AuthService authService = new AuthService();

        Disposable disposable = authService.register(context, authData)
                .subscribeOn(application.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {
                    Toast.makeText(context, response, Toast.LENGTH_SHORT).show();
                    notifyFoodsDataChanged();
                }, throwable -> {
                    Toast.makeText(context, throwable.toString(), Toast.LENGTH_SHORT).show();
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
