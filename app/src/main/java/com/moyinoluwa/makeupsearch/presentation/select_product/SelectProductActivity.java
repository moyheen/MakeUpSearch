package com.moyinoluwa.makeupsearch.presentation.select_product;

import android.content.Intent;
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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;
import com.moyinoluwa.makeupsearch.R;
import com.moyinoluwa.makeupsearch.presentation.search.MakeUpSearchActivity;

import java.util.Arrays;
import java.util.List;

public class SelectProductActivity extends AppCompatActivity implements SelectProductContract
        .View, ProductsAdapter.ProductsAdapterCallback{

    TextView textViewSearchIntro;
    TextView textViewProductName;
    LinearLayout selectProductContainer;
    RecyclerView recyclerViewProducts;
    ProductsAdapter productsAdapter;
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
        setUpFlexboxLayoutManager(layoutManager);

        brandsLayoutManager = new FlexboxLayoutManager();
        setUpFlexboxLayoutManager(brandsLayoutManager);

        String[] products = getResources().getStringArray(R.array.products_array);
        List<String> productsList = Arrays.asList(products);

        String[] brands = getResources().getStringArray(R.array.brands_array);
        List<String> brandsList = Arrays.asList(brands);

        productsAdapter = new ProductsAdapter(productsList);
        recyclerViewProducts.setLayoutManager(layoutManager);
        recyclerViewProducts.setAdapter(productsAdapter);

        brandsAdapter = new BrandsAdapter(brandsList);

        // TODO Check the second parameter in the method below
        selectProductPresenter = new SelectProductPresenter(selectProductContainer, "");
        selectProductPresenter.attachView(this);
    }

    private void setUpFlexboxLayoutManager(FlexboxLayoutManager layoutManager) {
        layoutManager.setFlexWrap(FlexWrap.WRAP);
        layoutManager.setAlignItems(AlignItems.BASELINE);
        layoutManager.setJustifyContent(JustifyContent.CENTER);
    }

    @Override
    public void switchActivity() {
        Intent intent = new Intent(this, MakeUpSearchActivity.class);
        // TODO: pass brand and product as intent extra too
        intent.putExtra("product_selected", "jjj");
        intent.putExtra("brand_selected", "nnn");
        startActivity(intent);
    }

    @Override
    public void setTransition() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            TransitionManager.beginDelayedTransition(selectProductContainer,
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
    public void setProductTextName(String productName) {
        textViewProductName.setText(productName + " from...");
    }

//    @Override
//    public void onBrandItemClick(View view) {
//        Toast.makeText(this, "brand clicked", Toast.LENGTH_SHORT).show();
//
//        switchActivity();
//    }
}
