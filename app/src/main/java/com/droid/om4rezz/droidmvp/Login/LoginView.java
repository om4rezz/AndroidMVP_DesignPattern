package com.droid.om4rezz.droidmvp.Login;

/**
 * Created by om4rezz on 3/12/17.
 */

interface LoginView {

    void showProgress();

    void hideProgress();

    void showUsernameError();

    void showPasswordError();

    void navigateToHome();
}
