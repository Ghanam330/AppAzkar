package com.example.appazkar.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appazkar.Model.Sabhe;
import com.example.appazkar.R;

import java.util.ArrayList;


public class SabaheAdabter extends RecyclerView.Adapter<SabaheAdabter.ViewHolder> {
    public ArrayList<Sabhe> sabhe;
    private OnAzkarItemClickListener listener;


    public SabaheAdabter(ArrayList<Sabhe>sabhe, OnAzkarItemClickListener listener) {
        this.sabhe = sabhe;
       this.listener=listener;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemcard_azkar_sbah, parent, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.textView.setText(sabhe.get(position).getAzkarText());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.OnItemClick(position,sabhe.get(position));
            }
        });
    }

    public interface OnAzkarItemClickListener{
        void OnItemClick(int position,Sabhe sabhe);
    }



    @Override
    public int getItemCount() {
        return sabhe.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_card_azkar_sabh);
        }
    }
}



