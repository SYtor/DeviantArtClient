package ua.sytor.deviantartclient.presentation.main.screens.host;

import android.view.View;

import javax.inject.Inject;

import ua.sytor.deviantartclient.presentation.base.BaseFragmentPresenter;

public class HostScreenPresenter extends BaseFragmentPresenter<HostScreenContract.View> implements HostScreenContract.Presenter {

    @Inject
    public HostScreenPresenter(HostScreenContract.View view) {
        super(view);
    }

    @Override
    public void onAttach(View view) {
        super.onAttach(view);

    }

}
