package com.droid.om4rezz.droidmvp.Login;

/**
 * Created by om4rezz on 3/12/17.
 */

class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener{

    LoginView loginView;
    private LoginInteractor loginInteractor;


    public LoginPresenterImpl(LoginView loginView) {

        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password) {
        if(loginView != null){
            loginView.showProgress();
        }
    }

    @Override
    public void onDestroy() {
        loginView = null;
    }

    @Override
    public void onUsernameError() {
        if(loginView != null) {
            loginView.showUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError() {
        if(loginView != null) {
            loginView.showPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess() {
        if(loginView!= null){
            loginView.navigateToHome();
        }
    }
}
