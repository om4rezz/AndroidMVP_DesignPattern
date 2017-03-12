package com.droid.om4rezz.droidmvp.Home;

/**
 * Created by om4rezz on 3/12/17.
 */

class HomePresenterImpl implements HomePresenter {

    private HomeView homeView;
    private FindItemsInteractor findItemsInteractor;

    public HomePresenterImpl(HomeView homeView, FindItemsInteractorImpl findItemsInteractor) {
        this.homeView = homeView;
        this.findItemsInteractor = findItemsInteractor;
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void onDestroy() {

    }
}
