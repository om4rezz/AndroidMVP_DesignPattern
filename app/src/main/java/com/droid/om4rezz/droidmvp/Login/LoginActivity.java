package com.droid.om4rezz.droidmvp.Login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.droid.om4rezz.droidmvp.Home.HomeActivity;
import com.droid.om4rezz.droidmvp.R;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private Button btnLogin, btnExit;
    private EditText etUsername, etPassword;
    private ProgressBar progressBar;

    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
    }

    private void initViews() {
        btnExit = (Button) findViewById(R.id.btn_exit);
        btnLogin = (Button) findViewById(R.id.btn_login);

        etPassword = (EditText) findViewById(R.id.et_password);
        etUsername = (EditText) findViewById(R.id.et_username);

        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        presenter = new LoginPresenterImpl(this);

        initEventDriven();
    }

    private void initEventDriven() {
        btnLogin.setOnClickListener(this);
        btnExit.setOnClickListener(this);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showUsernameError() {
        etUsername.setError(getString(R.string.username_error));
    }

    @Override
    public void showPasswordError() {
        etPassword.setError(getString(R.string.password_error));
    }

    @Override
    public void navigateToHome() {
        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                presenter.validateCredentials(username, password);

                break;

            case R.id.btn_exit:
                finish();
                break;
        }
    }
}
