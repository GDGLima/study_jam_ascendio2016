package com.carlospinan.playme.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.carlospinan.playme.R;
import com.carlospinan.playme.activities.DetailActivity;
import com.carlospinan.playme.adapters.PlayMeAdapter;
import com.carlospinan.playme.callback.OnInteractorListener;
import com.carlospinan.playme.callback.OnTaskListener;
import com.carlospinan.playme.helpers.CustomAsyncTask;
import com.carlospinan.playme.helpers.Globals;
import com.carlospinan.playme.helpers.Helper;
import com.carlospinan.playme.models.AudioModel;

import java.util.List;

/**
 * @author Carlos Piñan
 */
public class MainFragment extends Fragment implements OnTaskListener<List<AudioModel>>, OnInteractorListener<AudioModel> {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private CustomAsyncTask<List<AudioModel>> customAsyncTask;

    public static MainFragment newInstance() {
        MainFragment mainFragment = new MainFragment();
        return mainFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        customAsyncTask = new CustomAsyncTask<>(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        customAsyncTask.execute();
        return view;
    }

    @Override
    public void onInit() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public List<AudioModel> onCall() {
        return Helper.getAudios(getActivity());
    }

    @Override
    public void onSuccess(List<AudioModel> result) {
        if (result != null && !result.isEmpty()) {
            progressBar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            PlayMeAdapter adapter = new PlayMeAdapter(getActivity(), result, this);
            recyclerView.setAdapter(adapter);
        } else {
            onFailed();
        }
    }

    @Override
    public void onFailed() {
        Snackbar.make(
                recyclerView,
                R.string.there_was_a_problem,
                Snackbar.LENGTH_LONG
        ).show();
    }

    @Override
    public void onCancelled() { /* UNUSED */ }

    @Override
    public void onPause() {
        super.onPause();
        if (customAsyncTask != null) {
            customAsyncTask.cancel(true);
        }
    }

    @Override
    public void onClickListener(AudioModel audioModel) {
        if (audioModel != null) {
            Intent intent = new Intent(getActivity(), DetailActivity.class);
            intent.putExtra(Globals.AUDIO_KEY, audioModel);
            startActivity(intent);
        }
    }
}
