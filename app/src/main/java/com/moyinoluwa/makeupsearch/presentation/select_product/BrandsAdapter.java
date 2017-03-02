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

public class BrandsAdapter extends RecyclerView.Adapter<BrandsAdapter.BrandsViewHolder> {
    private List<String> items;

    BrandsAdapter(List<String> items) {
        this.items = items;
    }

    @Override
    public BrandsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.brand_item_layout,
                parent, false);

        return new BrandsViewHolder(v);
    }

    @Override
    public void onBindViewHolder(BrandsViewHolder holder, int position) {
        String item = items.get(position);

        holder.textViewBrands.setText(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class BrandsViewHolder extends RecyclerView.ViewHolder {
        final TextView textViewBrands;

        BrandsViewHolder(View v) {
            super(v);
            textViewBrands = (TextView) v.findViewById(R.id.brand_item);
        }
    }
}
