package ua.sytor.deviantartclient.core.utils;

import android.view.View;

import com.google.android.material.snackbar.BaseTransientBottomBar;

public class NotSwipableSnackbarBehavior extends BaseTransientBottomBar.Behavior {

    @Override
    public boolean canSwipeDismissView(View child) {
        return false;
    }

}
