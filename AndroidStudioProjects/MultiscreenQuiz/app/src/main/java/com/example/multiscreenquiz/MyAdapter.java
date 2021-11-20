package com.example.multiscreenquiz;

import android.icu.text.CaseMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<model> modelList;

    public MyAdapter(List<model> modelList) {
        this.modelList = modelList;
    }



    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.model_view,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    model model=modelList.get(position);
    holder.title.setText(model.getTitle());
    holder.date.setText(model.getDate());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    //    Creating View Holder Class:MyViewHolder
    public class MyViewHolder extends RecyclerView.ViewHolder{

    public TextView title,genre,date;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);

         title=itemView.findViewById(R.id.textView2);
         genre=itemView.findViewById(R.id.button);
         date=itemView.findViewById(R.id.editTextDate);




    }
}
}

