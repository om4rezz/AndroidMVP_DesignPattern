package com.droid.om4rezz.droidmvp.Home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

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
        progressBar = (ProgressBar) findViewById(R.id.progress);

        presenter = new HomePresenterImpl(this, new FindItemsInteractorImpl());

        initEventDriven();
    }

    private void initEventDriven() {
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        presenter.onItemClicked(position);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
        listView.setVisibility(View.VISIBLE);
    }

    @Override
    public void setItems(List<String> items) {
        listView.setAdapter(new ArrayAdapter<>(HomeActivity.this, android.R.layout.simple_list_item_1, items));
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(HomeActivity.this, message, Toast.LENGTH_LONG).show();
    }
}
