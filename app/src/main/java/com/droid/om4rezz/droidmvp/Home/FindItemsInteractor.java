package com.droid.om4rezz.droidmvp.Home;

import java.util.List;

/**
 * Created by om4rezz on 3/12/17.
 */

interface FindItemsInteractor {

    interface OnFinishedListener{
        void onFinished(List<String> items);
    }

    void findItems(OnFinishedListener listener);

}
