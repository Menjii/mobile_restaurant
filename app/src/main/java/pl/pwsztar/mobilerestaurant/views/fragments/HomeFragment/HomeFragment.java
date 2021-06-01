package pl.pwsztar.mobilerestaurant.views.fragments.HomeFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Observable;
import java.util.Observer;

import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;
import pl.pwsztar.mobilerestaurant.utils.UserModelUtils;
import pl.pwsztar.mobilerestaurant.views.adapters.FoodMenuAdapter;

public class HomeFragment extends Fragment implements Observer {
    private HomeFragmentViewModel viewModel;
    private FoodMenuAdapter foodMenuAdapter;
    private LoginResponse currentUser;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        currentUser = UserModelUtils.getUser(getContext());
        viewModel = new HomeFragmentViewModel(getContext());
        viewModel.addObserver(this);
        return inflater.inflate(R.layout.fragment_home, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        TextView tvUserName = requireActivity().findViewById(R.id.tv_user_name);
        tvUserName.setText(currentUser.getName() + " " + currentUser.getSurname());

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
