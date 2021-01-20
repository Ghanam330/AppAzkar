package com.example.appazkar.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appazkar.Model.AzkarName;
import com.example.appazkar.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AzkarAdapter extends FirebaseRecyclerAdapter<AzkarName,AzkarAdapter.MyViewHolder> {
    private FirebaseRecyclerOptions<AzkarName>options;
    OnAzkarItemClickListener listener;

    public AzkarAdapter(@NonNull FirebaseRecyclerOptions<AzkarName> options,OnAzkarItemClickListener listener) {
        super(options);
        this.options=options;
        this.listener=listener;
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull AzkarName model) {
        holder.textView.setText(model.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listener.OnItemClick(position);

            }
        });
    }
    public interface OnAzkarItemClickListener{
        void OnItemClick(int position);
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemcard_azkar_sbah, parent, false);
        return new AzkarAdapter.MyViewHolder(itemView);
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.text_card_azkar_sabh);

        }//constructor
    }// end MyViewHolder

}
