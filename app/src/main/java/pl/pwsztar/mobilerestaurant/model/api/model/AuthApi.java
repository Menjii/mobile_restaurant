package pl.pwsztar.mobilerestaurant.model.api.model;

import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginRequest;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface AuthApi {
    @POST("auth/signin")
    Observable<LoginResponse> login(@Body LoginRequest data);
}
