package com.droid.om4rezz.droidmvp.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.droid.om4rezz.droidmvp.R;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeView, AdapterView.OnItemClickListener {

    private ListView listView;
    private ProgressBar progressBar;
    private HomePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initViews();
    }

    private void initViews() {
        listView = (ListView) findViewById(R.id.mylist);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        presenter = new HomePresenterImpl(this, new FindItemsInteractorImpl());
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setItems(List<String> items) {

    }

    @Override
    public void showMessage(String message) {

    }
}
