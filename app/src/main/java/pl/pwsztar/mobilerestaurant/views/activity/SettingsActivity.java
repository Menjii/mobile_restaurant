package pl.pwsztar.mobilerestaurant.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import pl.pwsztar.mobilerestaurant.MainActivity;
import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;
import pl.pwsztar.mobilerestaurant.utils.UserModelUtils;
import pl.pwsztar.mobilerestaurant.views.fragments.HomeFragment.HomeFragment;
import pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment.MenuFragment;
import pl.pwsztar.mobilerestaurant.views.fragments.OrderFragment.OrderFragment;

public class SettingsActivity extends AppCompatActivity {
    private LoginResponse currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        currentUser = UserModelUtils.getUser(getApplicationContext());

        EditText etName = findViewById(R.id.et_name);
        etName.setText(currentUser.getName());
        EditText etSurname = findViewById(R.id.et_surname);
        etSurname.setText(currentUser.getSurname());
        EditText etPhoneNumber = findViewById(R.id.et_phone_number);
        etPhoneNumber.setText(currentUser.getPhone());
        EditText etStreet = findViewById(R.id.et_street);
        etStreet.setText(currentUser.getAddressDto().getStreet());
        EditText etHomeNumber = findViewById(R.id.et_home_number);
        etHomeNumber.setText(currentUser.getAddressDto().getHomeNumber());
        EditText etPostalCode = findViewById(R.id.et_postal_code);
        etPostalCode.setText(currentUser.getAddressDto().getPostNumber());
        EditText etCity = findViewById(R.id.et_city);
        etCity.setText(currentUser.getAddressDto().getCity());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
