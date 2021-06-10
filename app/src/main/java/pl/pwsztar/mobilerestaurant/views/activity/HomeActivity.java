package pl.pwsztar.mobilerestaurant.views.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
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
import pl.pwsztar.mobilerestaurant.views.activity.CreateOrderActivity.CreateOrderActivity;
import pl.pwsztar.mobilerestaurant.views.activity.LoginActivity.LoginActivity;
import pl.pwsztar.mobilerestaurant.views.fragments.HomeFragment.HomeFragment;
import pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment.MenuFragment;
import pl.pwsztar.mobilerestaurant.views.fragments.OrderFragment.OrderFragment;
import pl.pwsztar.mobilerestaurant.views.fragments.ShoppingFragment;

public class HomeActivity extends AppCompatActivity {
    private LoginResponse currentUser;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        currentUser = UserModelUtils.getUser(getApplicationContext());

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);

        TextView tvUserName = headerView.findViewById(R.id.nav_header_textView);

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        tvUserName.setText(currentUser.getName() + " " + currentUser.getSurname());
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.drawer_item_logout:
                    UserModelUtils.removeUser(getApplicationContext());
                    Intent intent = new Intent(this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    break;
            }
            return true;
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = item -> {
        // By using switch we can easily get
        // the selected fragment
        // by using there id.
        Fragment selectedFragment = null;
        switch (item.getItemId()) {
            case R.id.action_home:
                toolbar.setTitle("Badoro Dypama");
                selectedFragment = new HomeFragment();
                break;
            case R.id.action_restaurant_menu:
                selectedFragment = new MenuFragment();
                toolbar.setTitle("Menu");
                break;
            case R.id.action_orders:
                toolbar.setTitle("Twoje zamówienia");
                selectedFragment = new OrderFragment();
                break;
        }
        // It will help to replace the
        // one fragment to other.
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, selectedFragment)
                .commit();
        return true;
    };
}
