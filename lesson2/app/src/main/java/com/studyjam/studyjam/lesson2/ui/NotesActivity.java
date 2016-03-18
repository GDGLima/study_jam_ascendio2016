package com.studyjam.studyjam.lesson2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.studyjam.studyjam.lesson2.R;
import com.studyjam.studyjam.lesson2.adapter.NotesAdapter;
import com.studyjam.studyjam.lesson2.manager.NotesManager;
import com.studyjam.studyjam.lesson2.model.Note;

/**
 * Created by PedroCarrillo on 3/16/16.
 * Modified by Pablo Johnson on 3/18/16.
 */
public class NotesActivity extends AppCompatActivity {

    public static final String DATE = "date";
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    private ListView lvNotes;
    private NotesAdapter notesAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        setupViews();
    }

    private void setupViews() {
        lvNotes = (ListView) findViewById(R.id.lvNotes);
        notesAdapter = new NotesAdapter(NotesManager.getInstance().getNotes());
        lvNotes.setAdapter(notesAdapter);
        lvNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Note note = (Note) lvNotes.getItemAtPosition(position);
                Intent intent = new Intent(NotesActivity.this, DetailNoteActivity.class);
                intent.putExtra(TITLE, note.getTitle());
                intent.putExtra(DESCRIPTION, note.getDescription());
                intent.putExtra(DATE, note.getDate().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        notesAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.newNote:
                addNewNote();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void addNewNote() {
        Intent intent = new Intent(this, AddNoteActivity.class);
        startActivity(intent);
    }

}
