package com.moyinoluwa.makeupsearch.presentation.select_product;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.moyinoluwa.makeupsearch.R;

import java.util.List;

/**
 * Created by moyinoluwa on 2/28/17.
 */

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ProductsViewHolder> {
    private List<String> items;

    ProductsAdapter(List<String> items) {
        this.items = items;
    }

    @Override
    public ProductsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item_layout,
                parent, false);

        return new ProductsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductsViewHolder holder, int position) {
        String item = items.get(position);

        holder.textViewProducts.setText(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ProductsViewHolder extends RecyclerView.ViewHolder {
        final TextView textViewProducts;

        ProductsViewHolder(View v) {
            super(v);
            textViewProducts = (TextView) v.findViewById(R.id.product_item);
        }
    }
}
