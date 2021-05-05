package pl.pwsztar.mobilerestaurant.views.adapters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.model.dtos.FoodDto;

public class LastShippedFoodAdapter extends RecyclerView.Adapter<LastShippedFoodAdapter.ViewHolder> {

    private List<FoodDto> foodDtoList = new ArrayList<>();

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView foodName;
        private final TextView foodDesc;
        private final TextView foodPrize;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            foodName = (TextView) view.findViewById(R.id.food_name);
            foodDesc = (TextView) view.findViewById(R.id.food_desc);
            foodPrize = (TextView) view.findViewById(R.id.food_prize);
        }

        public TextView getFoodName() {
            return foodName;
        }

        public TextView getFoodDesc() {
            return foodDesc;
        }

        public TextView getFoodPrize() {
            return foodPrize;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * by RecyclerView.
     */
    public LastShippedFoodAdapter() {

    }

    public void update(List<FoodDto> newFoods) {
        Log.i("TEST", "Updated: " + newFoods.size());
        this.foodDtoList = newFoods;
        this.notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_last_shipped_food, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        FoodDto foodItem = foodDtoList.get(position);

        viewHolder.getFoodName().setText(foodItem.getName());
        viewHolder.getFoodDesc().setText(foodItem.getDescription());
        viewHolder.getFoodPrize().setText(foodItem.getPrice() + " zł");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return foodDtoList.size();
    }
}
