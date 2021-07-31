package com.uzun.json_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HelperAdapter extends RecyclerView.Adapter< HelperAdapter.MyViewClass > {
    ArrayList<String> name;
    ArrayList<String> username;
    Context context;
    // Конструктор
    public HelperAdapter(ArrayList<String> name, ArrayList<String> username, Context context) {
        this.name = name;
        this.username = username;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        MyViewClass myViewClass = new MyViewClass(view);
        return myViewClass;
    }

   // Всплывающий текст при нажатии на список
    @Override
    public void onBindViewHolder(@NonNull MyViewClass holder, int position) {
        holder.name.setText(name.get(position));
        holder.username.setText(username.get(position));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Item Clicked",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount(){
        return name.size();
    }

    public class MyViewClass extends RecyclerView.ViewHolder{
        TextView name;
        TextView username;
        public MyViewClass(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            username = itemView.findViewById(R.id.username);
        }
    }
}
