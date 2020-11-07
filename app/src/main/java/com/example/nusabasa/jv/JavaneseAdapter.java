package com.example.nusabasa.jv;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nusabasa.R;

import java.util.ArrayList;

public class JavaneseAdapter extends RecyclerView.Adapter<JavaneseAdapter.ListViewHolder> {
    private ArrayList<Javanese> listAssignment;


    public JavaneseAdapter(ArrayList<Javanese> list) {
        this.listAssignment = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_javanese, parent, false);
        return new JavaneseAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final Javanese assignment = listAssignment.get(position);
        holder.tvName.setText(assignment.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                switch (assignment.getName()) {
                    case "Pilihan Ganda 1": {
                        Intent intent = new Intent(context, QuizActivity.class);
                        context.startActivity(intent);
                        break;
                    }
                    case "Pilihan Ganda 2": {
                        Intent intent = new Intent(context, Quiz2Activity.class);
                        context.startActivity(intent);
                        break;
                    }
                    case "Pilihan Ganda 3": {
                        Intent intent = new Intent(context, Quiz3Activity.class);
                        context.startActivity(intent);
                        break;
                    }
                    case "Pilihan Ganda 4": {
                        Intent intent = new Intent(context, Quiz4Activity.class);
                        context.startActivity(intent);
                        break;
                    }
                    case "Pilihan Ganda 5": {
                        Intent intent = new Intent(context, Quiz5Activity.class);
                        context.startActivity(intent);
                        break;
                    }
                    case "Isian 1": {
                        Intent intent = new Intent(context, Quiz6Activity.class);
                        context.startActivity(intent);
                        break;
                    }
                    case "Isian 2": {
                        Intent intent = new Intent(context, Quiz7Activity.class);
                        context.startActivity(intent);
                        break;
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listAssignment.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        private Context context;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            context = itemView.getContext();
            tvName = itemView.findViewById(R.id.name_type);
        }
    }
}
