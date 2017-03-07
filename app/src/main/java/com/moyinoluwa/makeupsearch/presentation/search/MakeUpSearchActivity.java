package com.moyinoluwa.makeupsearch.presentation.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.moyinoluwa.makeupsearch.R;
import com.moyinoluwa.makeupsearch.data.remote.model.MakeUp;
import com.moyinoluwa.makeupsearch.injection.Injection;

import java.util.List;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MakeUpSearchActivity extends AppCompatActivity implements MakeUpSearchContract.View {
    private MakeUpSearchContract.Presenter makeupSearchPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_up_search);

        String message = getIntent().getStringExtra("product_selected") + " from " + getIntent()
                .getStringExtra("brand_selected");

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();

        makeupSearchPresenter = new MakeUpSearchPresenter(Injection.provideUserRepo(), Schedulers.io(),
                AndroidSchedulers.mainThread());
        makeupSearchPresenter.attachView(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        makeupSearchPresenter.detachView();
    }

    @Override
    public void showSearchResults(List<MakeUp> makeUpList) {

    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
