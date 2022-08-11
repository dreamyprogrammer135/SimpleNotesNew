package com.dreamyprogrammer.simplenotes;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ListNotesFragment.Controller, EditListNoteFragment.Controller {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new ListNotesFragment())
                .commit();

    }

    @Override
    public void openNotes(Task task) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, EditListNoteFragment.newInstance(task))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void saveNotes(Task task) {
        //todo Будет нужно когда инфу буду прокидывать в обе стороны.
        // пока думаю что куда вообще будет прокидываться.
    }

}