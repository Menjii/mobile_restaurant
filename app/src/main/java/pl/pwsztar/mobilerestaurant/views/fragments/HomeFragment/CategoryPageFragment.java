package pl.pwsztar.mobilerestaurant.views.fragments.HomeFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Observable;
import java.util.Observer;

import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.views.adapters.LastShippedFoodAdapter;
import pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment.MenuFragmentViewModel;

public class CategoryPageFragment  extends Fragment implements Observer {
    private LastShippedFoodAdapter lastShippedFoodAdapter;
    public static final String ARG_OBJECT = "object";

    private int categoryId;
    public CategoryPageFragment(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        MenuFragmentViewModel viewModel = new MenuFragmentViewModel(getContext(), categoryId);
        viewModel.addObserver(this);


        return inflater.inflate(R.layout.fragment_category_page, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        RecyclerView recyclerView = view.findViewById(R.id.list_last_shipped);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        lastShippedFoodAdapter = new LastShippedFoodAdapter();
        recyclerView.setAdapter(lastShippedFoodAdapter);
    }

    @Override
    public void update(Observable o, Object arg) {
        Log.i("TEST", "Booooooooooooom");
        if (o instanceof MenuFragmentViewModel) {
            MenuFragmentViewModel _viewModel = (MenuFragmentViewModel) o;
            if (lastShippedFoodAdapter != null) {
                lastShippedFoodAdapter.update(_viewModel.getFoodDtoList());
            }
        }
    }
}
