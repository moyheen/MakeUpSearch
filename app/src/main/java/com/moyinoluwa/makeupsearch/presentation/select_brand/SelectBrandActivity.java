package com.moyinoluwa.makeupsearch.presentation.select_brand;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.moyinoluwa.makeupsearch.R;

public class SelectBrandActivity extends AppCompatActivity implements SelectBrandContract.View {

    TextView textView;

    String productName;
    String brandName;
    static final String PRODUCT_NAME_KEY = "product_selected";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_brand);

        retrieveBundle();

        textView = (TextView) findViewById(R.id.textView_welcome);

        textView.setText(productName + " from...");
    }

    @Override
    public void switchActivity() {
        retrieveBundle();

        Intent intent = new Intent(this, SelectBrandActivity.class);
        intent.putExtra(PRODUCT_NAME_KEY, productName);
        intent.putExtra("brand_selected", brandName);
        startActivity(intent);
    }

    public void selectBrand(View view) {
        switch (view.getId()) {
            case R.id.button_blush:
                brandName = "blush";
                break;
            case R.id.button_bronzer:
                brandName = "bronzer";
                break;
            case R.id.button_eyebrow:
                brandName = "eyebrow";
                break;
            case R.id.button_eyeliner:
                brandName = "eyeliner";
                break;
            case R.id.button_eyeshadow:
                brandName = "eyeshadow";
                break;
            case R.id.button_foundation:
                brandName = "foundation";
                break;
            case R.id.button_lip_liner:
                brandName = "lip liner";
                break;
            case R.id.button_lipstick:
                brandName = "lipstick";
                break;
            case R.id.button_mascara:
                brandName = "mascara";
                break;
            case R.id.button_nail_polish:
                brandName = "nail polish";
                break;
        }

        switchActivity();
    }

    private void retrieveBundle() {
        productName = getIntent().getStringExtra(PRODUCT_NAME_KEY);
    }
}
