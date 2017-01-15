package com.moyinoluwa.makeupsearch.presentation.select;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.moyinoluwa.makeupsearch.R;

public class SelectProductActivity extends AppCompatActivity implements SelectProductContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_product);
    }

    @Override
    public void switchActivity() {

    }
}
