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
import android.view.ViewGroup;
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

    SelectProductContract.Presenter selectProductPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_product);

        textViewSearchIntro = (TextView) findViewById(R.id.textView_search_intro);
        linearLayoutContainer = (LinearLayout) findViewById(R.id.activity_select_product);
        selectProductContainer = (LinearLayout) findViewById(R.id.select_product_container);

        selectProductPresenter = new SelectProductPresenter(linearLayoutContainer,
                linearLayoutContainer);
        selectProductPresenter.attachView(this);
    }

    @Override
    public void switchActivity() {
//        Intent intent = new Intent(this, SelectBrandActivity.class);
//        // TO:DO pass brand and product as intent extra too
//        intent.putExtra("product_selected", buttonName);
//        startActivity(intent);
    }

    @Override
    public void setTransition(ViewGroup sceneRoot) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            TransitionManager.beginDelayedTransition(sceneRoot,
                    new TransitionSet()
                            .addTransition(new Fade())
                            .addTransition(new Slide(Gravity.START)));
        }
    }

    @Override
    public void switchViewsAfterTransition() {
        linearLayoutContainer.removeView(selectProductContainer);
        linearLayoutContainer.removeView(textViewSearchIntro);
        View child = getLayoutInflater().inflate(R.layout.layout_select_brand, null);
        textViewProductName = (TextView) child.findViewById(R.id.textView_productname);
        linearLayoutContainer.addView(child);
    }

    @Override
    public void setProductTextName() {
        textViewProductName.setText(buttonName + " from...");
    }

    @Override
    public void selectButtonClick(View view) {

        switch (view.getId()) {
            case R.id.button_blush:
                buttonName = Button.BLUSH;
                break;
            case R.id.button_bronzer:
                buttonName = Button.BRONZER;
                break;
            case R.id.button_eyebrow:
                buttonName = Button.EYEBROW;
                break;
            case R.id.button_eyeliner:
                buttonName = Button.EYELINER;
                break;
            case R.id.button_eyeshadow:
                buttonName = Button.EYESHADOW;
                break;
            case R.id.button_foundation:
                buttonName = Button.FOUNDATION;
                break;
            case R.id.button_lip_liner:
                buttonName = Button.LIP_LINER;
                break;
            case R.id.button_lipstick:
                buttonName = Button.LIPSTICK;
                break;
            case R.id.button_mascara:
                buttonName = Button.MASCARA;
                break;
            case R.id.button_nail_polish:
                buttonName = Button.NAIL_POLISH;
                break;
        }

        setTransition(linearLayoutContainer);
        switchViewsAfterTransition();
        setProductTextName();
    }

    public void selectBrandClick(View view) {
        Toast.makeText(this, "brand clicked", Toast.LENGTH_SHORT).show();

        //
        // switchActivity();
    }
}
