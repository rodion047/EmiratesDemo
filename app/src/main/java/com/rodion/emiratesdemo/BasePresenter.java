package com.rodion.emiratesdemo;

/**
 * Base presenter that all presenters should inherit from.
 */
public class BasePresenter<T> {

    private T view;

    protected final T getView() {
        return view;
    }

    public final void attachView(T view) {
        this.view = view;
        onViewAttached();
    }

    public final void detachView() {
        view = null;
        onViewDetached();
    }

    /**
     * Called when a view is attached to this presenter.
     */
    protected void onViewAttached() {
    }

    /**
     * Called when a view is detached from this presenter.
     */
    protected void onViewDetached() {
    }
}
