package com.moyinoluwa.makeupsearch.presentation.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.moyinoluwa.makeupsearch.R;

public class MakeUpSearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_up_search);

        String message = getIntent().getStringExtra("product_selected") + " from " +  getIntent()
                .getStringExtra("brand_selected");

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
