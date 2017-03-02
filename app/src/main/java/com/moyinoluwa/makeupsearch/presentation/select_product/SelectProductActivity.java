package com.moyinoluwa.makeupsearch.presentation.select_product;

import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
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

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.moyinoluwa.makeupsearch.R;

import java.util.Arrays;
import java.util.List;

public class SelectProductActivity extends AppCompatActivity implements SelectProductContract.View {
    String buttonName;
    TextView textViewSearchIntro;
    TextView textViewProductName;
    LinearLayout selectProductContainer;
    RecyclerView recyclerViewProducts;
    ProductsAdapter productsAdapter;

    TextView textViewBrandName;
    RecyclerView recyclerViewBrands;
    BrandsAdapter brandsAdapter;

    FlexboxLayoutManager brandsLayoutManager;

    SelectProductContract.Presenter selectProductPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_product);

        textViewSearchIntro = (TextView) findViewById(R.id.textView_search_intro);
        recyclerViewProducts = (RecyclerView) findViewById(R.id.product_recycler_view);
        selectProductContainer = (LinearLayout) findViewById(R.id.activity_select_product);

        FlexboxLayoutManager layoutManager = new FlexboxLayoutManager();
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setAlignItems(AlignItems.BASELINE);
        layoutManager.setJustifyContent(JustifyContent.CENTER);

        brandsLayoutManager = new FlexboxLayoutManager();
        brandsLayoutManager.setFlexWrap(FlexWrap.WRAP);
        brandsLayoutManager.setAlignItems(AlignItems.BASELINE);
        brandsLayoutManager.setJustifyContent(JustifyContent.CENTER);

        String[] products = getResources().getStringArray(R.array.products_array);
        List<String> productsList = Arrays.asList(products);

        String[] brands = getResources().getStringArray(R.array.brands_array);
        List<String> brandsList = Arrays.asList(brands);

        productsAdapter = new ProductsAdapter(productsList);
        recyclerViewProducts.setLayoutManager(layoutManager);
        recyclerViewProducts.setAdapter(productsAdapter);

        brandsAdapter = new BrandsAdapter(brandsList);

        selectProductPresenter = new SelectProductPresenter(selectProductContainer,
                selectProductContainer);
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
    public void onProductItemClick(View view) {

//        switch (view.getId()) {
//            case R.id.button_blush:
//                buttonName = Button.BLUSH;
//                break;
//            case R.id.button_bronzer:
//                buttonName = Button.BRONZER;
//                break;
//            case R.id.button_eyebrow:
//                buttonName = Button.EYEBROW;
//                break;
//            case R.id.button_eyeliner:
//                buttonName = Button.EYELINER;
//                break;
//            case R.id.button_eyeshadow:
//                buttonName = Button.EYESHADOW;
//                break;
//            case R.id.button_foundation:
//                buttonName = Button.FOUNDATION;
//                break;
//            case R.id.button_lip_liner:
//                buttonName = Button.LIP_LINER;
//                break;
//            case R.id.button_lipstick:
//                buttonName = Button.LIPSTICK;
//                break;
//            case R.id.button_mascara:
//                buttonName = Button.MASCARA;
//                break;
//            case R.id.button_nail_polish:
//                buttonName = Button.NAIL_POLISH;
//                break;
//        }

        setTransition(selectProductContainer);
        switchViewsAfterTransition();
        setProductTextName();
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
        selectProductContainer.removeView(textViewSearchIntro);
        selectProductContainer.removeView(recyclerViewProducts);
        View child = getLayoutInflater().inflate(R.layout.layout_select_brand, null);
        textViewProductName = (TextView) child.findViewById(R.id.textView_productname);
        recyclerViewBrands = (RecyclerView) child.findViewById(R.id.brand_recycler_view);
        recyclerViewBrands.setLayoutManager(brandsLayoutManager);
        recyclerViewBrands.setAdapter(brandsAdapter);
        selectProductContainer.addView(child);
    }

    @Override
    public void setProductTextName() {
        textViewProductName.setText(buttonName + " from...");
    }

    @Override
    public void onBrandItemClick(View view) {
        Toast.makeText(this, "brand clicked", Toast.LENGTH_SHORT).show();

        //
        // switchActivity();
    }
}
