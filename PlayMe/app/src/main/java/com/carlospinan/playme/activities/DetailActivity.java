package com.carlospinan.playme.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.carlospinan.playme.R;
import com.carlospinan.playme.fragments.DetailFragment;
import com.carlospinan.playme.helpers.Globals;
import com.carlospinan.playme.models.AudioModel;

/**
 * @author Carlos Piñan
 */
public class DetailActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(Globals.AUDIO_KEY)) {
            AudioModel audioModel = (AudioModel) extras.getSerializable(Globals.AUDIO_KEY);
            loadFragment(R.id.container, DetailFragment.newInstance(audioModel));
        } else {
            DetailActivity.this.finish();
        }
    }
}
