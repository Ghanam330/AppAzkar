package com.example.appazkar.Adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appazkar.Model.AzkarDetails;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AzkarDetailsAdapter extends FirebaseRecyclerAdapter<AzkarDetails,AzkarDetailsAdapter.MyViewHolder> {


    public AzkarDetailsAdapter(@NonNull FirebaseRecyclerOptions<AzkarDetails> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull AzkarDetails model) {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);



        }//constructor
    }// end MyViewHolder


}
