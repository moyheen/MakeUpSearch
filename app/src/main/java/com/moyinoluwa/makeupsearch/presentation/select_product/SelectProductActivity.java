package com.moyinoluwa.makeupsearch.presentation.select_product;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.moyinoluwa.makeupsearch.R;
import com.moyinoluwa.makeupsearch.presentation.select_brand.SelectBrandActivity;

public class SelectProductActivity extends AppCompatActivity implements SelectProductContract.View {
    String buttonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_product);
    }

    @Override
    public void switchActivity() {
        Intent intent = new Intent(this, SelectBrandActivity.class);
        intent.putExtra("product_selected", buttonName);
        startActivity(intent);
    }

    public void selectButtonClick(View view) {

        switch (view.getId()) {
            case R.id.button_blush:
                buttonName = "blush";
                break;
            case R.id.button_bronzer:
                buttonName = "bronzer";
                break;
            case R.id.button_eyebrow:
                buttonName = "eyebrow";
                break;
            case R.id.button_eyeliner:
                buttonName = "eyeliner";
                break;
            case R.id.button_eyeshadow:
                buttonName = "eyeshadow";
                break;
            case R.id.button_foundation:
                buttonName = "foundation";
                break;
            case R.id.button_lip_liner:
                buttonName = "lip liner";
                break;
            case R.id.button_lipstick:
                buttonName = "lipstick";
                break;
            case R.id.button_mascara:
                buttonName = "mascara";
                break;
            case R.id.button_nail_polish:
                buttonName = "nail polish";
                break;
        }

        switchActivity();
    }

}
