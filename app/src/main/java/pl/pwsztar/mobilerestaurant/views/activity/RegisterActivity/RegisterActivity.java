package pl.pwsztar.mobilerestaurant.views.activity.RegisterActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Observable;
import java.util.Observer;

import pl.pwsztar.mobilerestaurant.MainActivity;
import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginRequest;
import pl.pwsztar.mobilerestaurant.model.dtos.SignUpRequest;
import pl.pwsztar.mobilerestaurant.utils.UserModelUtils;
import pl.pwsztar.mobilerestaurant.views.activity.LoginActivity.LoginActivityViewModel;

public class RegisterActivity extends AppCompatActivity implements Observer {
    RegisterActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        viewModel = new RegisterActivityViewModel(this);
        viewModel.addObserver(this);


        Button registerButton = findViewById(R.id.btn_register);
        EditText etLogin = findViewById(R.id.et_username);
        EditText etPassword = findViewById(R.id.et_password);
        EditText etEmail = findViewById(R.id.et_email);
        registerButton.setOnClickListener((o) -> {
            SignUpRequest signUpRequest = new SignUpRequest(etLogin.getText().toString(), etEmail.getText().toString(), etPassword.getText().toString());
            Log.i("TEST", signUpRequest.toString());
            viewModel.register(signUpRequest);
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        this.finish();
    }
}
