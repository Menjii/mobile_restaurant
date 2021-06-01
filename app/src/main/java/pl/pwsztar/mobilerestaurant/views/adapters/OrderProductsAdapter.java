package pl.pwsztar.mobilerestaurant.views.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderDataDto;
import pl.pwsztar.mobilerestaurant.model.dtos.ProductDto;

public class OrderProductsAdapter extends RecyclerView.Adapter<OrderProductsAdapter.ViewHolder> {

    private List<ProductDto> productList = new ArrayList<>();

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvProductName;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvProductName = (TextView) view.findViewById(R.id.tv_product_name);
        }

        public TextView getTvProductName() {
            return tvProductName;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * by RecyclerView.
     */
    public OrderProductsAdapter() {
    }

    public void update(List<ProductDto> productList) {
        this.productList = productList;
        this.notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_order_product, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        ProductDto product = productList.get(position);
        viewHolder.getTvProductName().setText(product.getFood().getName());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return productList.size();
    }
}
