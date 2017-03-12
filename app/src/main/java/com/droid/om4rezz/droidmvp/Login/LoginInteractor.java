package com.droid.om4rezz.droidmvp.Login;

/**
 * Created by om4rezz on 3/12/17.
 */

interface LoginInteractor {

    public interface OnLoginFinishedListener {
        void onUsernameError();
        void onPasswordError();
        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);
}
