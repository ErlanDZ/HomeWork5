package com.example.homework5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.TaskViewHolder> {
    private List<TaskModel> list = new ArrayList<>();

    public Adapter(List<TaskModel> list) {
        this.list = list;
    }

    public OnMoveTo onMoveTo;


    public void setOnMoveTo(OnMoveTo onMoveTo) {
        this.onMoveTo = onMoveTo;
    }

    public void addData (TaskModel taskMOdel){
        list.add(taskMOdel);
        notifyDataSetChanged();
    }

    public void editAdd(TaskModel taskMOdel, int position){
        list.set(position, taskMOdel);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task,parent,false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {
        TextView txt_item_task, txt_item_task_description;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_item_task = itemView.findViewById(R.id.txt_item_task);
            txt_item_task_description = itemView.findViewById(R.id.txt_item_task_description);
        }

        public void onBind (TaskModel taskModel){
            txt_item_task.setText(taskModel.getTitle());
            txt_item_task_description.setText(taskModel.getDescription());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //OnMoveTo.On
                }
            });
        }
    }
}
