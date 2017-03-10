package com.moyinoluwa.makeupsearch.presentation.display_product_desc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.moyinoluwa.makeupsearch.R;
import com.moyinoluwa.makeupsearch.data.remote.model.ProductColor;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class DisplayProductsDescActivity extends AppCompatActivity {
    ImageView imageViewToolbar;
    TextView textViewProductTitle;
    TextView textViewProductPrice;
    TextView textViewProductDescription;
    RecyclerView productColorContainer;

    String name;
    String price;
    String imageLink;
    String productLink;
    String description;
    ProductColorAdapter productColorAdapter;
    ArrayList<ProductColor> productColorArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_products_desc);

        imageViewToolbar = (ImageView) findViewById(R.id.toolbar_image);
        textViewProductTitle = (TextView) findViewById(R.id.textView_title);
        textViewProductPrice = (TextView) findViewById(R.id.textView_price);
        textViewProductDescription = (TextView) findViewById(R.id.textView_description);
        productColorContainer = (RecyclerView) findViewById(R.id.product_color_container);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        retrieveDataFromIntent();
        setToolbarImage();
        setUiText();
        setProductColors();
    }

    private void retrieveDataFromIntent() {
        name = getIntent().getStringExtra("name");

        price = (price == null) ? "No price available" : getIntent().getStringExtra("price");

        imageLink = getIntent().getStringExtra("image_link");
        productLink = getIntent().getStringExtra("product_link");
        description = getIntent().getStringExtra("description");
        productColorArrayList = getIntent().getParcelableArrayListExtra("product_colors");
    }

    private void setToolbarImage() {
        Picasso.with(this).load(imageLink).into(imageViewToolbar);
    }

    private void setUiText() {
        textViewProductTitle.setText(name);
        textViewProductPrice.setText(price);
        textViewProductDescription.setText(description);
    }

    private void setProductColors() {

        if (productColorArrayList != null) {
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                    LinearLayoutManager.HORIZONTAL, false);

            productColorAdapter = new ProductColorAdapter(productColorArrayList);
            productColorContainer.setLayoutManager(linearLayoutManager);
            productColorContainer.setAdapter(productColorAdapter);
            productColorContainer.setVisibility(View.VISIBLE);
        }
    }
}
