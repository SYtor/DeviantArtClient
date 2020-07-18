package ua.sytor.deviantartclient.core.navigator;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import javax.inject.Inject;

public class Navigator implements NavigatorContract.Navigator {

    private NavController navController;

    @Inject
    public Navigator(Fragment fragment) {
        navController = NavHostFragment.findNavController(fragment);
    }

    @Override
    public void setupToolbar(Toolbar toolbar) {
        NavigationUI.setupWithNavController(toolbar, navController);
    }

    @Override
    public void navigate(int destinationId) {
        navController.navigate(destinationId);
    }

}
