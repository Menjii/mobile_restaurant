package pl.pwsztar.mobilerestaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import pl.pwsztar.mobilerestaurant.views.fragments.HomeFragment.HomeFragment;
import pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment.MenuFragment;
import pl.pwsztar.mobilerestaurant.views.fragments.ShoppingFragment;

public class MainActivity extends AppCompatActivity {
  private Toolbar toolbar;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
    bottomNav.setOnNavigationItemSelectedListener(navListener);

    toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close);
    drawerLayout.addDrawerListener(toggle);
    toggle.syncState();


    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
  }

  private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      // By using switch we can easily get
      // the selected fragment
      // by using there id.
      Fragment selectedFragment = null;
      switch (item.getItemId()) {
        case R.id.action_home:
          selectedFragment = new HomeFragment();
          break;
        case R.id.action_restaurant_menu:
          selectedFragment = new MenuFragment();

          break;
        case R.id.action_orders:
          selectedFragment = new ShoppingFragment();
          break;
      }
      // It will help to replace the
      // one fragment to other.
      getSupportFragmentManager()
              .beginTransaction()
              .replace(R.id.fragment_container, selectedFragment)
              .commit();
      return true;
    }
  };
}
