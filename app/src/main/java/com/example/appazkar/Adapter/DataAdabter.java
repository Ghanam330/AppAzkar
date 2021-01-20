package com.example.appazkar.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appazkar.Model.Datamodel;
import com.example.appazkar.R;

import java.util.ArrayList;


public class DataAdabter extends RecyclerView.Adapter<DataAdabter.ViewHolder> {
    private ArrayList<Datamodel> datamodels;
    private OnDataItemClickListener listener;

    public DataAdabter(ArrayList<Datamodel> datamodels,OnDataItemClickListener listener) {
        this.datamodels = datamodels;
        this.listener=listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item, parent, false);
        return new ViewHolder(view);
    }

    public interface OnDataItemClickListener{
        Fragment OnItemClick(int position);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imageView.setImageResource(datamodels.get(position).getImage());
        holder.textView.setText(datamodels.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnItemClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datamodels.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_card);
            textView = itemView.findViewById(R.id.text_card);
        }
    }
}



