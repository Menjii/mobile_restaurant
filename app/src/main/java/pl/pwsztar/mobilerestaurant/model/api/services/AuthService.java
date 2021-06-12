package pl.pwsztar.mobilerestaurant.model.api.services;

import android.content.Context;
import android.util.Log;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.api.RestProvider;
import pl.pwsztar.mobilerestaurant.model.dtos.FoodDto;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginRequest;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;
import pl.pwsztar.mobilerestaurant.model.dtos.SignUpRequest;

public class AuthService {
    public Observable<LoginResponse> login(Context context, LoginRequest data) {
        return RestProvider.getInstance(context).getAuthApi().login(data);
    }

    public Observable<String> register(Context context, SignUpRequest data) {
        return RestProvider.getInstance(context).getAuthApi().register(data);
    }
}
