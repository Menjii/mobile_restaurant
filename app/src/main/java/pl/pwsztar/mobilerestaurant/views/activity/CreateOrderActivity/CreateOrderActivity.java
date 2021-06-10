package pl.pwsztar.mobilerestaurant.views.activity.CreateOrderActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Observable;
import java.util.Observer;

import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;
import pl.pwsztar.mobilerestaurant.utils.UserModelUtils;
import pl.pwsztar.mobilerestaurant.views.fragments.HomeFragment.HomeFragment;
import pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment.MenuFragment;
import pl.pwsztar.mobilerestaurant.views.fragments.OrderFragment.OrderFragment;

public class CreateOrderActivity extends AppCompatActivity implements Observer {
  private LoginResponse currentUser;
  private CreateOrderActivityViewModel viewModel;
  private Toolbar toolbar;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_order);
    currentUser = UserModelUtils.getUser(getApplicationContext());
    viewModel = new CreateOrderActivityViewModel(getApplicationContext());
    viewModel.addObserver(this);
  }

  @Override
  public void update(Observable o, Object arg) {
    LinearLayout spinner = findViewById(R.id.layout_is_loading);
    spinner.setVisibility(View.GONE);
    LinearLayout successLayout = findViewById(R.id.layout_success);
    successLayout.setVisibility(View.VISIBLE);

    Button btnBack = findViewById(R.id.btn_back);
    btnBack.setOnClickListener((e) -> {
      this.finish();
    });
  }
}
