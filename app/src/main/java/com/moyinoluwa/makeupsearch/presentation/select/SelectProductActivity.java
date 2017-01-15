package com.moyinoluwa.makeupsearch.presentation.select;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.moyinoluwa.makeupsearch.R;

public class SelectProductActivity extends AppCompatActivity implements SelectProductContract.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_product);
    }

    @Override
    public void switchActivity(String buttonName) {
        Intent intent = new Intent(this, SelectProductActivity.class);
        intent.putExtra("product_selected", buttonName);
        startActivity(intent);
    }

    public void selectButtonClick(View view) {
        Button button = (Button) findViewById(view.getId());
        switchActivity(button.getText().toString());
    }

}
