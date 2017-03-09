package com.moyinoluwa.makeupsearch.presentation.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.moyinoluwa.makeupsearch.R;
import com.moyinoluwa.makeupsearch.data.remote.model.MakeUp;
import com.moyinoluwa.makeupsearch.injection.Injection;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MakeUpSearchActivity extends AppCompatActivity implements MakeUpSearchContract.View {

    private ProgressBar progressBar;
    private RecyclerView recyclerViewMakeUp;
    private TextView textViewErrorMessage;
    private TextView textViewEmptyMessage;
    private TextView textViewGoBackMessage;
    private LottieAnimationView lottieAnimationView;
    private MakeUpSearchAdapter makeUpSearchAdapter;

    private MakeUpSearchContract.Presenter makeupSearchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_up_search);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        textViewErrorMessage = (TextView) findViewById(R.id.text_view_error_msg);
        textViewEmptyMessage = (TextView) findViewById(R.id.textView_empty_in_here);
        textViewGoBackMessage = (TextView) findViewById(R.id.textView_go_back_and_search);
        recyclerViewMakeUp = (RecyclerView) findViewById(R.id.recycler_view_makeup);
        lottieAnimationView = (LottieAnimationView) findViewById(R.id.animation_view);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,
                StaggeredGridLayoutManager.VERTICAL);


        makeUpSearchAdapter = new MakeUpSearchAdapter(null);
        recyclerViewMakeUp.setLayoutManager(staggeredGridLayoutManager);
        recyclerViewMakeUp.setAdapter(makeUpSearchAdapter);

        makeupSearchPresenter = new MakeUpSearchPresenter(Injection.provideUserRepo(), Schedulers.io(),
                AndroidSchedulers.mainThread());
        makeupSearchPresenter.attachView(this);

        String brand = getIntent().getStringExtra("brand_selected");
        String product = getIntent().getStringExtra("product_selected");

        makeupSearchPresenter.search(brand, product);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeupSearchPresenter.detachView();
    }

    @Override
    public void showSearchResults(List<MakeUp> makeUpList) {
        textViewErrorMessage.setVisibility(View.GONE);
        recyclerViewMakeUp.setVisibility(View.VISIBLE);
        makeUpSearchAdapter.setItems(makeUpList);
    }

    @Override
    public void showError(String message) {
        textViewErrorMessage.setVisibility(View.VISIBLE);
        recyclerViewMakeUp.setVisibility(View.GONE);
        textViewErrorMessage.setText(message);
    }

    @Override
    public void showEmptyState() {
        textViewErrorMessage.setVisibility(View.GONE);
        recyclerViewMakeUp.setVisibility(View.GONE);
        lottieAnimationView.setVisibility(View.VISIBLE);
        textViewEmptyMessage.setVisibility(View.VISIBLE);
        textViewGoBackMessage.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerViewMakeUp.setVisibility(View.GONE);
        textViewErrorMessage.setVisibility(View.GONE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
        recyclerViewMakeUp.setVisibility(View.VISIBLE);
        textViewErrorMessage.setVisibility(View.GONE);
    }
}
