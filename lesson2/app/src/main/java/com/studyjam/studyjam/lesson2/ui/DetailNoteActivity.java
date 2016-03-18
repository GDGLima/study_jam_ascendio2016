package com.studyjam.studyjam.lesson2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.studyjam.studyjam.lesson2.R;

/**
 * Created by Pablo Johnson on 3/18/16.
 */
public class DetailNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_note);
        if (getIntent() != null) {
            TextView noteTitle = (TextView) findViewById(R.id.noteTitle);
            TextView noteDescription = (TextView) findViewById(R.id.noteDescription);
            TextView noteDate = (TextView) findViewById(R.id.noteDate);

            noteTitle.setText(getIntent().getStringExtra(NotesActivity.TITLE));
            noteDescription.setText(getIntent().getStringExtra(NotesActivity.DESCRIPTION));
            noteDate.setText(getIntent().getStringExtra(NotesActivity.DATE));
        }
    }
}
