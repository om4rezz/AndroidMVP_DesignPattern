package com.droid.om4rezz.droidmvp.Home;

import java.util.List;

/**
 * Created by om4rezz on 3/12/17.
 */

class HomePresenterImpl implements HomePresenter, FindItemsInteractor.OnFinishedListener {

    private HomeView homeView;
    private FindItemsInteractor findItemsInteractor;

    public HomePresenterImpl(HomeView homeView, FindItemsInteractorImpl findItemsInteractor) {
        this.homeView = homeView;
        this.findItemsInteractor = findItemsInteractor;
    }

    @Override
    public void onResume() {
        if (homeView != null) {
            homeView.showProgress();
        }

        findItemsInteractor.findItems(this);
    }

    @Override
    public void onItemClicked(int position) {
        if (homeView != null) {
            homeView.showMessage(String.format("Position %d clicked.!", position + 1));
        }
    }

    @Override
    public void onDestroy() {
        homeView = null;
    }

    @Override
    public void onFinished(List<String> items) {
        if(homeView!=null){
            homeView.setItems(items);
            homeView.hideProgress();
        }
    }

    public HomeView getHomeView(){
        return homeView;
    }
}
