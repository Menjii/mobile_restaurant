package pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.Observable;
import java.util.Observer;

import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.views.activity.ShoppingCardActivity.ShoppingCardActivity;
import pl.pwsztar.mobilerestaurant.views.adapters.CategoryPageAdapter;

public class MenuFragment extends Fragment implements Observer {
    private TextView txtViewCount;
    private MenuFragmentViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        viewModel = new MenuFragmentViewModel(getContext());
        viewModel.addObserver(this);
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_menu, parent, false);
    }

    // This event is triggered soon after onCreateView().
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        // Setup any handles to view objects here
        // EditText etFoo = (EditText) view.findViewById(R.id.etFoo);

        CategoryPageAdapter categoryPageAdapter = new CategoryPageAdapter(getChildFragmentManager(), viewModel);
        ViewPager viewPager = view.findViewById(R.id.pager);
        viewPager.setAdapter(categoryPageAdapter);

        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.txtViewCount.setText(String.valueOf((viewModel.itemsInStore)));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.shopping_card, menu);

        final View notificaitons = menu.findItem(R.id.toolbar_shopping_card).getActionView();

        notificaitons.setOnClickListener((e) -> {
            Intent intent = new Intent(getActivity(), ShoppingCardActivity.class);
            startActivity(intent);
        });
        txtViewCount = (TextView) notificaitons.findViewById(R.id.txtCount);
        this.txtViewCount.setText(String.valueOf((viewModel.itemsInStore)));
        super.onCreateOptionsMenu(menu,inflater);
    }
}
