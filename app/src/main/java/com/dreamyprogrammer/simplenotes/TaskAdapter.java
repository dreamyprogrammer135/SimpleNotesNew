package com.dreamyprogrammer.simplenotes;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskVievHolder> {
    private List<Task> data = new ArrayList<>();
    private OnItemClickListener onItemClickListener;

    //получаем данные в адаптере
    public void setData(List<Task> tasks) {
        data = tasks;
        notifyDataSetChanged(); // Уведомили что данные изменились
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    //создание View
//    public TaskVievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task,parent,false);
//        return new TaskVievHolder(view);
//    }

    public TaskVievHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskVievHolder(parent, onItemClickListener);
    }

    @Override
    //связка View с даными
    public void onBindViewHolder(@NonNull TaskVievHolder holder, int position) {
        holder.bind(data.get(position));

    }

    //полуение размера списка
    @Override
    public int getItemCount() {
        return data.size();
    }

    interface OnItemClickListener {
        void onItemClick(Task task);
    }
}
