package pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment;

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
import pl.pwsztar.mobilerestaurant.views.adapters.FoodMenuAdapter;
import pl.pwsztar.mobilerestaurant.views.fragments.MenuFragment.CategoryViewModel;

public class CategoryPageFragment  extends Fragment implements Observer {
    private FoodMenuAdapter foodMenuAdapter;
    public static final String ARG_OBJECT = "object";
    private TextView tvCategoryDesc;
    private MenuFragmentViewModel viewModel;

    private int categoryId;
    public CategoryPageFragment(int categoryId, MenuFragmentViewModel viewModel) {
        this.categoryId = categoryId;
        this.viewModel = viewModel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        CategoryViewModel viewModel = new CategoryViewModel(getContext(), categoryId);
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
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        foodMenuAdapter = new FoodMenuAdapter(viewModel);
        recyclerView.setAdapter(foodMenuAdapter);

        tvCategoryDesc = view.findViewById(R.id.category_description);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof CategoryViewModel) {
            CategoryViewModel _viewModel = (CategoryViewModel) o;
            if (foodMenuAdapter != null) {
                foodMenuAdapter.update(_viewModel.getFoodDtoList());
                if( _viewModel.getFoodDtoList().size() > 0 ) {
                    tvCategoryDesc.setText(_viewModel.getFoodDtoList().get(0).getCategory().getDescription());
                }
            }
        }
    }
}
