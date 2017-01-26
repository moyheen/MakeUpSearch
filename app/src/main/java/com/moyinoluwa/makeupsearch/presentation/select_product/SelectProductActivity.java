package com.moyinoluwa.makeupsearch.presentation.select_product;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

    SelectProductContract.Presenter selectProductPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_product);

        textViewSearchIntro = (TextView) findViewById(R.id.textView_search_intro);
        linearLayoutContainer = (LinearLayout) findViewById(R.id.activity_select_product);
        selectProductContainer = (LinearLayout) findViewById(R.id.select_product_container);

        selectProductPresenter = new SelectProductPresenter();
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

    public void selectButtonClick(View view) {

        switch (view.getId()) {
            case R.id.button_blush:
                selectProductPresenter.getButtonName(Button.BLUSH);
                break;
            case R.id.button_bronzer:
                selectProductPresenter.getButtonName(Button.BRONZER);
                break;
            case R.id.button_eyebrow:
                selectProductPresenter.getButtonName(Button.EYEBROW);
                break;
            case R.id.button_eyeliner:
                selectProductPresenter.getButtonName(Button.EYELINER);
                break;
            case R.id.button_eyeshadow:
                selectProductPresenter.getButtonName(Button.EYESHADOW);
                break;
            case R.id.button_foundation:
                selectProductPresenter.getButtonName(Button.FOUNDATION);
                break;
            case R.id.button_lip_liner:
                selectProductPresenter.getButtonName(Button.LIP_LINER);
                break;
            case R.id.button_lipstick:
                selectProductPresenter.getButtonName(Button.LIPSTICK);
                break;
            case R.id.button_mascara:
                selectProductPresenter.getButtonName(Button.MASCARA);
                break;
            case R.id.button_nail_polish:
                selectProductPresenter.getButtonName(Button.NAIL_POLISH);
                break;
        }

        selectProductPresenter.setTransition(linearLayoutContainer);
        switchViewsAfterTransition();

    }

    public void selectBrandClick(View view) {
        Toast.makeText(this, "brand clicked", Toast.LENGTH_SHORT).show();

        //
        // switchActivity();
    }
}
