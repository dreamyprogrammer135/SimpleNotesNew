package com.dreamyprogrammer.simplenotes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ListNotesFragment extends Fragment {
    private final ArrayList<Task> taskList = new ArrayList<>();
    private RecyclerView recyclerView;
    private TaskAdapter adapter;
    private BottomNavigationView bottomNavigationView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        findView(view);
        setupView();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (!(context instanceof Contract)) {
            throw new IllegalStateException(getString(R.string.erroe_contract));
        }
    }

    private void findView(View view) {
        //получили recycler_view
        recyclerView = view.findViewById(R.id.recycler_view);
        bottomNavigationView = view.findViewById(R.id.nav_view);
        bottomNavigationView.setOnNavigationItemSelectedListener(this::navigate);

    }

    private void setupView() {
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        adapter = new TaskAdapter();
        adapter.setOnItemClickListener(item -> getContract().openTask(item));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        addTaskList(taskList);
        //после получения recycler_view сунули туда адаптер
    }

    private boolean navigate(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_task: {
                getContract().createTask();
            }
            break;
            default:
                return true;
        }
        return true;
    }

    private Contract getContract() {
        return (Contract) getActivity();
    }


    private void addTaskList(List<Task> taskList) {
        adapter.setData(taskList);
    }


    public void addTask(Task task) {
        if (task != null) {
            taskList.add(task);
        }
        addTaskList(taskList);
    }


    interface Contract {
        void createTask();

        void openTask(Task task);
    }
}