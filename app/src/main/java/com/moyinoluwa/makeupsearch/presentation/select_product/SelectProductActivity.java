package com.moyinoluwa.makeupsearch.presentation.select_product;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.moyinoluwa.makeupsearch.R;

public class SelectProductActivity extends AppCompatActivity implements SelectProductContract.View {
    String buttonName;
    TextView textViewSearchIntro;
    TextView textViewProductName;
    LinearLayout linearLayoutContainer;
    LinearLayout selectProductContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_product);

        textViewSearchIntro = (TextView) findViewById(R.id.textView_search_intro);
        linearLayoutContainer = (LinearLayout) findViewById(R.id.activity_select_product);
        selectProductContainer = (LinearLayout) findViewById(R.id.select_product_container);
    }

    @Override
    public void switchActivity() {
//        Intent intent = new Intent(this, SelectBrandActivity.class);
//        // TO:DO pass brand and product as intent extra too
//        intent.putExtra("product_selected", buttonName);
//        startActivity(intent);
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

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            TransitionManager.beginDelayedTransition(linearLayoutContainer,
                    new TransitionSet()
                            .addTransition(new Fade())
                            .addTransition(new Slide(Gravity.START)));
        }

        linearLayoutContainer.removeView(selectProductContainer);
        linearLayoutContainer.removeView(textViewSearchIntro);
        View child = getLayoutInflater().inflate(R.layout.layout_select_brand, null);
        textViewProductName = (TextView) child.findViewById(R.id.textView_productname);

        textViewProductName.setText(buttonName + " from...");

        linearLayoutContainer.addView(child);
    }

    public void selectBrandClick(View view) {
        Toast.makeText(this, "brand clicked", Toast.LENGTH_SHORT).show();

        //
        // switchActivity();
    }
}
