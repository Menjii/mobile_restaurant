package pl.pwsztar.mobilerestaurant.views.fragments.OrderFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Observable;
import java.util.Observer;

import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;
import pl.pwsztar.mobilerestaurant.utils.UserModelUtils;
import pl.pwsztar.mobilerestaurant.views.adapters.OrdersAdapter;

public class OrderFragment extends Fragment implements Observer {
    private OrderFragmentViewModel viewModel;
    private OrdersAdapter ordersAdapter;
    private LoginResponse currentUser;
    private RecyclerView recyclerView;
    private View view;

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
        this.view = view;
        recyclerView = view.findViewById(R.id.orders);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        ordersAdapter = new OrdersAdapter(getContext());
        recyclerView.setAdapter(ordersAdapter);

    }

    @Override
    public void update(Observable o, Object arg) {
        LinearLayout list = view.findViewById(R.id.layout_list);
        list.setVisibility(View.VISIBLE);
        LinearLayout isLoading = view.findViewById(R.id.layout_is_loading);
        isLoading.setVisibility(View.GONE);

        if (o instanceof OrderFragmentViewModel) {
            OrderFragmentViewModel _viewModel = (OrderFragmentViewModel) o;
            if (ordersAdapter != null) {
                RelativeLayout emptyOrders = requireActivity().findViewById(R.id.empty_orders);
                if(_viewModel.getOrderList().isEmpty()) {
                    emptyOrders.setVisibility(View.VISIBLE);
                    recyclerView.setVisibility(View.GONE);
                } else {
                    ordersAdapter.update(_viewModel.getOrderList());
                    recyclerView.setVisibility(View.VISIBLE);
                    emptyOrders.setVisibility(View.GONE);
                }
            }
        }
    }
}
