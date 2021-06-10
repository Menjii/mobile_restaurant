package pl.pwsztar.mobilerestaurant.views.adapters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment.CategoryPageFragment;
import pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment.MenuFragmentViewModel;

public class CategoryPageAdapter extends FragmentStatePagerAdapter {
    private MenuFragmentViewModel viewModel;
    public CategoryPageAdapter(FragmentManager fm, MenuFragmentViewModel viewModel) {
        super(fm);
        this.viewModel = viewModel;
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new CategoryPageFragment(i+1, viewModel);
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
