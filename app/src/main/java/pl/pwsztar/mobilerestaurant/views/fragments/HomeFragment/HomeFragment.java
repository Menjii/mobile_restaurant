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

public class HomeFragment extends Fragment implements Observer {
    private HomeFragmentViewModel viewModel;
    private LastShippedFoodAdapter lastShippedFoodAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        viewModel = new HomeFragmentViewModel(getContext());
        viewModel.addObserver(this);
        return inflater.inflate(R.layout.fragment_home, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
