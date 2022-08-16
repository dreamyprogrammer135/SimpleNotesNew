package com.dreamyprogrammer.simplenotes;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ListNotesFragment.Contract, EditListNoteFragment.Contract {
    private static final String NOTES_LIST_FRAGMENT_TAG = "NOTES_LIST_FRAGMENT_TAG";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setView();
    }

    private void setView() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new ListNotesFragment(), NOTES_LIST_FRAGMENT_TAG)
                .commit();
    }

    private void showEditTask(@Nullable Task task) {
        setTitle(task == null ? "Создание заметки" : "Редактируем заметку");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, EditListNoteFragment.newInstance(task))
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void createTask() {
        showEditTask(null);
    }

    @Override
    public void openTask(Task task) {
        showEditTask(task);
    }

    @Override
    public void saveNotes(Task task) {
        setTitle(R.string.app_name);
        getSupportFragmentManager().popBackStack();
        ListNotesFragment listNotesFragment = (ListNotesFragment) getSupportFragmentManager().findFragmentByTag(NOTES_LIST_FRAGMENT_TAG);
        assert listNotesFragment != null;
        listNotesFragment.addTask(task);
    }

}