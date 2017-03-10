package com.moyinoluwa.makeupsearch.presentation.display_product_desc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.moyinoluwa.makeupsearch.R;
import com.squareup.picasso.Picasso;


public class DisplayProductsDescActivity extends AppCompatActivity {
    ImageView imageViewToolbar;
    TextView textViewProductTitle;
    TextView textViewProductPrice;
    TextView textViewProductDescription;

    String name;
    String price;
    String imageLink;
    String productLink;
    String description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_products_desc);

        imageViewToolbar = (ImageView) findViewById(R.id.toolbar_image);
        textViewProductTitle = (TextView) findViewById(R.id.textView_title);
        textViewProductPrice = (TextView) findViewById(R.id.textView_price);
        textViewProductDescription = (TextView) findViewById(R.id.textView_description);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("");

        retrieveDataFromIntent();
        setToolbarImage();
        setUiText();
    }

    private void retrieveDataFromIntent() {
        name = getIntent().getStringExtra("name");

        price = (price == null) ? "No price available" : getIntent().getStringExtra("price");

        imageLink = getIntent().getStringExtra("image_link");
        productLink = getIntent().getStringExtra("product_link");
        description = getIntent().getStringExtra("description");
    }

    private void setToolbarImage() {
        Picasso.with(this).load(imageLink).into(imageViewToolbar);
    }

    private void setUiText() {
        textViewProductTitle.setText(name);
        textViewProductPrice.setText(price);
        textViewProductDescription.setText(description);
    }
}
