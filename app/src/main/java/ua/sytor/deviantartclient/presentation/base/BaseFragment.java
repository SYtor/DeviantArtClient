package ua.sytor.deviantartclient.presentation.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<V extends FragmentView, P extends BaseFragmentPresenter<V>> extends Fragment {

    @LayoutRes
    @NonNull
    abstract protected Integer getLayoutResId();

    abstract protected P getPresenter();

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater,
            @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState
    ) {
        return inflater.inflate(getLayoutResId(), container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getPresenter().onAttach(view);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        getPresenter().onDetach();
    }

}
