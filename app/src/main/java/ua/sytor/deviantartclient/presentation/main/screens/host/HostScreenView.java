package ua.sytor.deviantartclient.presentation.main.screens.host;

import android.view.View;

import javax.inject.Inject;

import ua.sytor.deviantartclient.core.logger.Logger;
import ua.sytor.deviantartclient.core.navigator.NavigatorContract;

public class HostScreenView implements HostScreenContract.View {

    private NavigatorContract.Navigator navigator;

    @Inject
    public HostScreenView(NavigatorContract.Navigator navigator) {
        Logger.log("LoginScreenView");
        this.navigator = navigator;
    }

    @Override
    public void onAttach(View view) {

    }

    @Override
    public void onDetach() {

    }

}
