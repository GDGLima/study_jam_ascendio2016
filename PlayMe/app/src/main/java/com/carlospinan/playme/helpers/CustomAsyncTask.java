package com.carlospinan.playme.helpers;

import android.os.AsyncTask;

import com.carlospinan.playme.callback.OnTaskListener;

/**
 * @author Carlos Piñan
 */
public class CustomAsyncTask<T> extends AsyncTask<Void, Void, T> {

    private OnTaskListener<T> listener;

    public CustomAsyncTask(OnTaskListener<T> listener) {
        if (listener == null) {
            throw new IllegalArgumentException("Listener must not be null");
        }
        this.listener = listener;
    }

    @Override
    protected void onPreExecute() {
        listener.onInit();
    }

    @Override
    protected T doInBackground(Void... params) {
        return listener.onCall();
    }

    @Override
    protected void onPostExecute(T result) {
        if (result != null) {
            listener.onSuccess(result);
        } else {
            listener.onFailed();
        }
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
        listener.onCancelled();
    }

}
