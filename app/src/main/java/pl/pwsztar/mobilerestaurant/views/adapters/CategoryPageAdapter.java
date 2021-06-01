package pl.pwsztar.mobilerestaurant.views.adapters;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.common.data.DataBufferObserver;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.views.fragments.HomeFragment.CategoryPageFragment;
import pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment.MenuFragmentViewModel;

public class CategoryPageAdapter extends FragmentStatePagerAdapter {
    public CategoryPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new CategoryPageFragment(i+1);
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putInt(CategoryPageFragment.ARG_OBJECT, i + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    String[] categories = {"Zestawy", "Napoje", "Pizza", "Sosy"};
    @Override
    public CharSequence getPageTitle(int position) {
        return categories[position];
    }
}
