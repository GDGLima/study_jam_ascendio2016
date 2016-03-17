package com.studyjam.studyjam.lesson2.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.studyjam.studyjam.lesson2.R;
import com.studyjam.studyjam.lesson2.adapter.NotesAdapter;
import com.studyjam.studyjam.lesson2.manager.NotesManager;

/**
 * Created by PedroCarrillo on 3/16/16.
 */
public class NotesActivity extends AppCompatActivity {

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
    }


}
