package pl.pwsztar.mobilerestaurant.views.fragments.OrderFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Observable;
import java.util.Observer;

import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;
import pl.pwsztar.mobilerestaurant.utils.UserModelUtils;
import pl.pwsztar.mobilerestaurant.views.adapters.FoodMenuAdapter;
import pl.pwsztar.mobilerestaurant.views.adapters.OrdersAdapter;
import pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment.MenuFragmentViewModel;

public class OrderFragment extends Fragment implements Observer {
    private OrderFragmentViewModel viewModel;
    private OrdersAdapter ordersAdapter;
    private LoginResponse currentUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        currentUser = UserModelUtils.getUser(getContext());
        viewModel = new OrderFragmentViewModel(getContext());
        viewModel.addObserver(this);
        return inflater.inflate(R.layout.fragment_order, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        RecyclerView recyclerView = view.findViewById(R.id.orders);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        ordersAdapter = new OrdersAdapter(getContext());
        recyclerView.setAdapter(ordersAdapter);

    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof OrderFragmentViewModel) {
            OrderFragmentViewModel _viewModel = (OrderFragmentViewModel) o;
            if (ordersAdapter != null) {
                ordersAdapter.update(_viewModel.getOrderList());
            }
        }
    }
}
