package pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Observable;
import java.util.Observer;

import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.views.adapters.CategoryPageAdapter;
import pl.pwsztar.mobilerestaurant.views.adapters.LastShippedFoodAdapter;
import pl.pwsztar.mobilerestaurant.views.fragments.HomeFragment.HomeFragmentViewModel;

public class MenuFragment extends Fragment implements Observer {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment


        return inflater.inflate(R.layout.fragment_menu, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        CategoryPageAdapter categoryPageAdapter = new CategoryPageAdapter(getChildFragmentManager());
        ViewPager viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(categoryPageAdapter);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
