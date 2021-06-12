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
import pl.pwsztar.mobilerestaurant.model.dtos.LoginResponse;
import pl.pwsztar.mobilerestaurant.model.dtos.OrderDataDto;
import pl.pwsztar.mobilerestaurant.utils.UserModelUtils;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {

    private List<OrderDataDto> ordersList = new ArrayList<>();
    private Context context;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvOrderDate;
        private final TextView tvOrderStatus;
        private final TextView tvOrderAddress;
        private final TextView tvPriceSum;
        private final RecyclerView orderProductsList;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            tvOrderDate = (TextView) view.findViewById(R.id.tv_order_date);
            tvOrderStatus = (TextView) view.findViewById(R.id.tv_order_status);
            tvOrderAddress = (TextView) view.findViewById(R.id.tv_order_address);
            tvPriceSum = (TextView) view.findViewById(R.id.tv_order_price);
            orderProductsList = (RecyclerView) view.findViewById(R.id.order_products);
        }

        public TextView getTvOrderDate() {
            return tvOrderDate;
        }

        public TextView getTvPriceSum() {
            return tvPriceSum;
        }

        public TextView getTvOrderStatus() {
            return tvOrderStatus;
        }

        public TextView getTvOrderAddress() {
            return tvOrderAddress;
        }

        public RecyclerView getOrderProductsList() {
            return orderProductsList;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * by RecyclerView.
     */
    public OrdersAdapter(Context context) {
        this.context = context;
    }

    public void update(List<OrderDataDto> ordersList) {
        this.ordersList = ordersList;
        Log.e("TEST", String.valueOf(ordersList.size()));
        this.notifyDataSetChanged();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_order, viewGroup, false);

        return new ViewHolder(view);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        OrderDataDto order = ordersList.get(position);
        viewHolder.tvOrderDate.setText(String.valueOf(order.getOrder().getPaymentData().getStartData()));
        viewHolder.tvPriceSum.setText(String.valueOf(order.getOrder().getPaymentData().getAmount()) + " zł");
        viewHolder.tvOrderStatus.setText(String.valueOf(order.getOrder().getRealizationStatus()));
        LoginResponse currentUser = UserModelUtils.getUser(context);
        String addressText = currentUser.getAddressDto().getStreet() + " " +
                currentUser.getAddressDto().getHomeNumber() + "\n" +
                currentUser.getAddressDto().getPostNumber() + " " +
                currentUser.getAddressDto().getCity() + "\n";
        viewHolder.tvOrderAddress.setText(addressText);

        viewHolder.getOrderProductsList().setNestedScrollingEnabled(false);
        viewHolder.getOrderProductsList().setHasFixedSize(true);
        viewHolder.getOrderProductsList().setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        OrderProductsAdapter orderProductsAdapter = new OrderProductsAdapter();
        viewHolder.getOrderProductsList().setAdapter(orderProductsAdapter);

        orderProductsAdapter.update(order.getProducts());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return ordersList.size();
    }
}
