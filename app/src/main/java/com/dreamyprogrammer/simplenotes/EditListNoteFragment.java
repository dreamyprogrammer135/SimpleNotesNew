package com.dreamyprogrammer.simplenotes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EditListNoteFragment extends Fragment {

    private static final String TASK_ELEMENT_ARGS_KEY = "TASK_ELEMENT_ARGS_KEY";
    private EditText editTextNotes;
    private Task task;


    public static EditListNoteFragment newInstance(Task task) {
        EditListNoteFragment editListNotes = new EditListNoteFragment();
        Bundle args = new Bundle();
        args.putParcelable(TASK_ELEMENT_ARGS_KEY, task);
        editListNotes.setArguments(args);
        return editListNotes;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_edit_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView(view);
        setView();
    }

    private void setView() {
        editTextNotes.setText(task.toString());
    }

    private void findView(View view) {
        editTextNotes = view.findViewById(R.id.edit_text_notes);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (!(context instanceof Controller)) {
            throw new RuntimeException(getString(R.string.error_implement_controller));
        }
        if (getArguments() != null) {
            task = getArguments().getParcelable(TASK_ELEMENT_ARGS_KEY);
        }
    }

    interface Controller {
        void saveNotes(Task task);
    }


}
