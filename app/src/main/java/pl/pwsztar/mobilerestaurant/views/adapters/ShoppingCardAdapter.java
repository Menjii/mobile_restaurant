package pl.pwsztar.mobilerestaurant.views.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pl.pwsztar.mobilerestaurant.R;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderDataDto;
import pl.pwsztar.mobilerestaurant.model.dtos.ProductDto;
import pl.pwsztar.mobilerestaurant.views.activity.ShoppingCardActivity.ShoppingCardActivityViewModel;

public class ShoppingCardAdapter extends RecyclerView.Adapter<ShoppingCardAdapter.ViewHolder> {

    private List<ProductDto> productList = new ArrayList<>();
    private Context context;
    private ShoppingCardActivityViewModel viewModel;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvProductName;
        private final TextView tvProductCount;
        private final TextView tvProductPrice;
        private final Button btnOnAdd;
        private final Button btnOnRemove;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvProductName = (TextView) view.findViewById(R.id.tv_product_name);
            tvProductCount = (TextView) view.findViewById(R.id.tv_product_count);
            tvProductPrice = (TextView) view.findViewById(R.id.tv_product_price);
            btnOnAdd = (Button) view.findViewById(R.id.btn_on_add);
            btnOnRemove = (Button) view.findViewById(R.id.btn_on_remove);
        }

        public TextView getTvProductName() {
            return tvProductName;
        }

        public TextView getTvProductCount() {
            return tvProductCount;
        }

        public TextView getTvProductPrice() {
            return tvProductPrice;
        }

        public Button getBtnOnAdd() {
            return btnOnAdd;
        }

        public Button getBtnOnRemove() {
            return btnOnRemove;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * by RecyclerView.
     */
    public ShoppingCardAdapter(Context context, ShoppingCardActivityViewModel viewModel) {
        this.context = context;
        this.viewModel = viewModel;
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
                .inflate(R.layout.item_shopping_card, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        ProductDto product = productList.get(position);
        viewHolder.getTvProductName().setText(product.getFood().getName());
        viewHolder.getTvProductCount().setText(String.valueOf(product.getCount()));

        int price = product.getCount() * product.getFood().getPrice();
        viewHolder.getTvProductPrice().setText(price + " zł");

        viewHolder.getBtnOnAdd().setOnClickListener((e) -> {
           viewModel.onAddItem(product.getFood());
        });

        viewHolder.getBtnOnRemove().setOnClickListener((e) -> {
            viewModel.onRemoveItem(product.getFood());
        });
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return productList.size();
    }
}
