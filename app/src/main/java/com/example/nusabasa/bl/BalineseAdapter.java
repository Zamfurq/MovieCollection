package com.example.nusabasa.bl;

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

public class BalineseAdapter extends RecyclerView.Adapter<BalineseAdapter.ListViewHolder>{
    private ArrayList<Balinese> listAssignment;


    public BalineseAdapter(ArrayList<Balinese> list) {
        this.listAssignment = list;
    }

    @NonNull
    @Override
    public BalineseAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_balinese, parent, false);
        return new BalineseAdapter.ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BalineseAdapter.ListViewHolder holder, int position) {
        final Balinese assignment = listAssignment.get(position);
        holder.tvName.setText(assignment.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                switch (assignment.getName()) {
                    case "Pilihan Ganda 1": {
                        Intent intent = new Intent(context, BaliQuizActivity.class);
                        context.startActivity(intent);
                        break;
                    }
                    case "Pilihan Ganda 2": {
                        Intent intent = new Intent(context, BaliQuiz2Activity.class);
                        context.startActivity(intent);
                        break;
                    }
                    case "Pilihan Ganda 3": {
                        Intent intent = new Intent(context, BaliQuiz3Activity.class);
                        context.startActivity(intent);
                        break;
                    }
                    case "Isian 1": {
                        Intent intent = new Intent(context, BaliQuiz6Activity.class);
                        context.startActivity(intent);
                        break;
                    }
                    case "Isian 2": {
                        Intent intent = new Intent(context, BaliQuiz7Activity.class);
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
            tvName = itemView.findViewById(R.id.question_type);
        }
    }
}
