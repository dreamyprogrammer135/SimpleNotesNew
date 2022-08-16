package com.dreamyprogrammer.simplenotes;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

//здесь какая то логика
public class TaskVievHolder extends RecyclerView.ViewHolder {
    private final TextView subjectTextView;
    private final CardView cardView;
    private Task task;

//    public TaskVievHolder(@NonNull View itemView) {
//        super(itemView);
//        subjectTextView = itemView.findViewById(R.id.subject_text_view);
//    }

    public TaskVievHolder(@NonNull ViewGroup parent, @NonNull TaskAdapter.OnItemClickListener clickListener) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false));
        cardView = (CardView) itemView;
        subjectTextView = itemView.findViewById(R.id.subject_text_view);
        cardView.setOnClickListener(view -> {
            if (clickListener != null) {
                clickListener.onItemClick(task);
            }
        });

    }


    public void bind(Task task) {
        this.task = task;
        subjectTextView.setText(task.toString());
    }
}
