package ua.sytor.deviantartclient.presentation.base;

import android.view.View;

import androidx.annotation.CallSuper;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.Disposable;

public abstract class BaseFragmentPresenter<V extends FragmentView> {

    private List<Disposable> disposableList = new ArrayList<>();

    private V view;

    public BaseFragmentPresenter(V view) {
        this.view = view;
    }

    @CallSuper
    public void onAttach(View view) {
        this.view.onAttach(view);
    }

    @CallSuper
    public void onDetach() {
        for (Disposable disposable : disposableList) {
            disposable.dispose();
        }
        disposableList.clear();
        view.onDetach();
    }

    public void addDisposable(Disposable disposable) {
        disposableList.add(disposable);
    }

    protected V getView() {
        return view;
    }

}
