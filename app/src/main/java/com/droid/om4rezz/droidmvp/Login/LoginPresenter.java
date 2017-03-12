package com.droid.om4rezz.droidmvp.Login;

/**
 * Created by om4rezz on 3/12/17.
 */

interface LoginPresenter {

    void validateCredentials(String username, String password);

    void onDestroy();
}
