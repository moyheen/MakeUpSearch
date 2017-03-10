package com.moyinoluwa.makeupsearch.presentation.display_product_desc;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.moyinoluwa.makeupsearch.R;
import com.moyinoluwa.makeupsearch.data.remote.model.ProductColor;

import java.util.ArrayList;

/**
 * Created by moyinoluwa on 3/9/17.
 */

public class ProductColorAdapter extends RecyclerView.Adapter<ProductColorAdapter
        .ProductColorsViewHolder> {

    private ArrayList<ProductColor> items;

    ProductColorAdapter(ArrayList<ProductColor> items) {
        this.items = items;
    }

    @Override
    public ProductColorsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout
                        .product_color_item_layout, parent, false);

        return new ProductColorsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductColorsViewHolder holder, int position) {
        ProductColor item = items.get(position);

        holder.productColorItem.setBackgroundColor(Color.parseColor(item.getHexValue()));
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }

    class ProductColorsViewHolder extends RecyclerView.ViewHolder {
        final LinearLayout productColorItem;

        ProductColorsViewHolder(View v) {
            super(v);
            productColorItem = (LinearLayout) v.findViewById(R.id.product_color_item);
        }
    }
}
