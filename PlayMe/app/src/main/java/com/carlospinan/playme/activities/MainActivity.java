package com.carlospinan.playme.activities;

import android.os.Bundle;

import com.carlospinan.playme.R;
import com.carlospinan.playme.fragments.MainFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            loadFragment(R.id.container, MainFragment.newInstance());
        }
    }
}
