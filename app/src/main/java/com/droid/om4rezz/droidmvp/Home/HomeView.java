package com.droid.om4rezz.droidmvp.Home;

import java.util.List;

/**
 * Created by om4rezz on 3/12/17.
 */

interface HomeView {

    void showProgress();

    void hideProgress();

    void setItems(List<String> items);

    void showMessage(String message);
}
