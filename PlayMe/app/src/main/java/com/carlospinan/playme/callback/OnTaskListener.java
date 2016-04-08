package com.carlospinan.playme.callback;

/**
 * @author Carlos Piñan
 */
public interface OnTaskListener<T> {

    void onInit();

    T onCall();

    void onSuccess(T result);

    void onFailed();

    void onCancelled();

}
