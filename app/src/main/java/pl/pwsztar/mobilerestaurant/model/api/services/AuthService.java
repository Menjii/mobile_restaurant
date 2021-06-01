package pl.pwsztar.mobilerestaurant.model.api.services;

import android.util.Log;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.api.RestProvider;
import pl.pwsztar.mobilerestaurant.model.dtos.FoodDto;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginRequest;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;

public class AuthService {
    public Observable<LoginResponse> login(LoginRequest data) {
        return RestProvider.getInstance().getAuthApi().login(data);
    }
}
