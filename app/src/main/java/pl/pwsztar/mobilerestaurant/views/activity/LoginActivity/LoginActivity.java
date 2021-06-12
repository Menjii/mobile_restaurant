package pl.pwsztar.mobilerestaurant.views.activity.LoginActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Observable;
import java.util.Observer;

import pl.pwsztar.mobilerestaurant.MainActivity;
import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginRequest;
import pl.pwsztar.mobilerestaurant.utils.UserModelUtils;
import pl.pwsztar.mobilerestaurant.views.activity.RegisterActivity.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements Observer {
    LoginActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewModel = new LoginActivityViewModel(this);
        viewModel.addObserver(this);


        Button loginButton = findViewById(R.id.btn_login);
        EditText etLogin = findViewById(R.id.et_username);
        EditText etPassword = findViewById(R.id.et_password);
        loginButton.setOnClickListener((o) -> {
            LoginRequest loginRequest = new LoginRequest(etLogin.getText().toString(), etPassword.getText().toString());

            viewModel.login(loginRequest);
        });

        Button btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener((e) -> {
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        if( viewModel.loginResponse != null ) {
            UserModelUtils.saveUser(getApplicationContext(), viewModel.loginResponse);

            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
            startActivity(intent);
        }
    }
}
