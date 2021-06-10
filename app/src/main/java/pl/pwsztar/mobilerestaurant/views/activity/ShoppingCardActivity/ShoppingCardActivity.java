package pl.pwsztar.mobilerestaurant.views.activity.ShoppingCardActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Observable;
import java.util.Observer;

import pl.pwsztar.mobilerestaurant.MainActivity;
import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;
import pl.pwsztar.mobilerestaurant.utils.ShoppingCardUtils;
import pl.pwsztar.mobilerestaurant.utils.UserModelUtils;
import pl.pwsztar.mobilerestaurant.views.activity.CreateOrderActivity.CreateOrderActivity;
import pl.pwsztar.mobilerestaurant.views.adapters.FoodMenuAdapter;
import pl.pwsztar.mobilerestaurant.views.adapters.ShoppingCardAdapter;
import pl.pwsztar.mobilerestaurant.views.fragments.HomeFragment.HomeFragment;
import pl.pwsztar.mobilerestaurant.views.fragments.HomeFragment.HomeFragmentViewModel;
import pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment.MenuFragment;
import pl.pwsztar.mobilerestaurant.views.fragments.OrderFragment.OrderFragment;

public class ShoppingCardActivity extends AppCompatActivity implements Observer {
  private LoginResponse currentUser;
  private TextView tvPriceSum;
  private Toolbar toolbar;
  private ShoppingCardActivityViewModel viewModel;
  private ShoppingCardAdapter shoppingCardAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_shopping_card);
    currentUser = UserModelUtils.getUser(getApplicationContext());

    viewModel = new ShoppingCardActivityViewModel(getApplicationContext());
    viewModel.addObserver(this);

    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);


    RecyclerView recyclerView = findViewById(R.id.shopping_card_list);
    recyclerView.setNestedScrollingEnabled(false);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
    shoppingCardAdapter = new ShoppingCardAdapter(getApplicationContext(), viewModel);
    recyclerView.setAdapter(shoppingCardAdapter);
    shoppingCardAdapter.update(viewModel.shoppingCardItems);

    tvPriceSum = findViewById(R.id.shopping_card_price_sum);
    tvPriceSum.setText(viewModel.prizeInt + " zł");

    Button btnGoToPayment = findViewById(R.id.btn_go_to_payment);
    btnGoToPayment.setOnClickListener((e) -> {
      Intent intent = new Intent(this, CreateOrderActivity.class);
      intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_TASK_ON_HOME);
      startActivity(intent);
    });
  }

  @Override
  public boolean onSupportNavigateUp() {
    onBackPressed();
    return true;
  }

  @Override
  public void update(Observable o, Object arg) {
    shoppingCardAdapter.update(viewModel.shoppingCardItems);
    tvPriceSum.setText(viewModel.prizeInt + " zł");
  }
}
