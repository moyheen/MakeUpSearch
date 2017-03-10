package com.moyinoluwa.makeupsearch.presentation.display_product_desc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.moyinoluwa.makeupsearch.R;
import com.squareup.picasso.Picasso;


public class DisplayProductsDescActivity extends AppCompatActivity {
    ImageView imageViewToolbar;

    String name;
    String price;
    String imageLink;
    String productLink;
    String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_products_desc);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("");

        imageViewToolbar = (ImageView) findViewById(R.id.toolbar_image);

        retrieveDataFromIntent();
        setToolbarImage();
    }

    private void retrieveDataFromIntent() {
        name = getIntent().getStringExtra("name");
        price = getIntent().getStringExtra("price");
        imageLink = getIntent().getStringExtra("image_link");
        productLink = getIntent().getStringExtra("product_link");
        description = getIntent().getStringExtra("description");
    }

    private void setToolbarImage() {
        Picasso.with(this).load(imageLink).into(imageViewToolbar);
    }
}
