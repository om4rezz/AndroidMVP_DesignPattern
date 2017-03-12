package com.droid.om4rezz.droidmvp.Login;

import android.os.Handler;
import android.text.TextUtils;

/**
 * Created by om4rezz on 3/12/17.
 */

class LoginInteractorImpl implements LoginInteractor {
    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        // Mock login. I am creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean error = false;
                if(TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    error = true;
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    error = true;
                    return;
                }
                if(!error){
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
