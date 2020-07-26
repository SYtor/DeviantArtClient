package ua.sytor.deviantartclient.core.navigator;

import androidx.annotation.IdRes;
import androidx.appcompat.widget.Toolbar;

public interface NavigatorContract {

    interface Navigator {

        void setupToolbar(Toolbar toolbar);

        void navigate(@IdRes int destinationId);
        void navigateBack();

    }

}
