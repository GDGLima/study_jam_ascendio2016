package com.studyjam.studyjam.lesson2.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import com.studyjam.studyjam.lesson2.R;
import com.studyjam.studyjam.lesson2.manager.NotesManager;

/**
 * Created by Pablo Johnson on 3/18/16.
 */
public class DetailNoteActivity extends AppCompatActivity {

    public int notePosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_note);
        if (getIntent() != null) {
            TextView noteTitle = (TextView) findViewById(R.id.noteTitle);
            TextView noteDescription = (TextView) findViewById(R.id.noteDescription);
            TextView noteDate = (TextView) findViewById(R.id.noteDate);

            notePosition = getIntent().getIntExtra(NotesActivity.POSITION, 0);
            noteTitle.setText(getIntent().getStringExtra(NotesActivity.TITLE));
            noteDescription.setText(getIntent().getStringExtra(NotesActivity.DESCRIPTION));
            noteDate.setText(getIntent().getStringExtra(NotesActivity.DATE));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.removeDelete) {
            NotesManager.getInstance().removeNoteByPosition(notePosition);
            setResult(60);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
