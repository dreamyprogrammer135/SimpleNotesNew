package com.dreamyprogrammer.simplenotes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListNotesFragment extends Fragment {
    private final Task task1 = new Task("Разобраться с фрагментами");
    private final Task task2 = new Task("Купить велосипед");
    private final Task task3 = new Task("Поиграть с детьми");
    private final Task task4 = new Task("Разобрать в шкафу");
    private final Task task5 = new Task("Сделать грядки");
    private LinearLayout linearList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_notes, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findView(view);
        setupView();
    }

    private void findView(View view) {
        linearList = view.findViewById(R.id.linear_list);
    }

    private void setupView() {
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        addTask(task1);
        addTask(task2);
        addTask(task3);
        addTask(task4);
        addTask(task5);

    }

    private void addTask(Task task) {
        Button button = new Button(getContext());
        button.setText(task.toString());
        button.setOnClickListener(v -> ((Controller) getActivity()).openNotes(task));
        linearList.addView(button);
    }


    interface Controller {
        void openNotes(Task task);
    }
}