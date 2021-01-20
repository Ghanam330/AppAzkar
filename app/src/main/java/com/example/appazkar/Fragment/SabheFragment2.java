package com.example.appazkar.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appazkar.R;

public class SabheFragment2 extends Fragment {

    private ImageView backBtn;
    Fragment fragment;
    int allcount = 0;
    TextView textView_counter, azkar_text;
    ImageView imageView_refrech;

    public SabheFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sabhe2, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        backBtn = view.findViewById(R.id.back_pressed);
        textView_counter = view.findViewById(R.id.counter_tex_total);
        imageView_refrech = view.findViewById(R.id.imageView_refrech);
        azkar_text = view.findViewById(R.id.text_Azkar);

        if (getArguments() != null) {
            azkar_text.setText(getArguments().getString("Ahmed"));
        }
        imageView_refrech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allcount = 0;
                textView_counter.setText("" + allcount);
            }
        });

        textView_counter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (allcount <= 49) {
                    allcount++;
                    textView_counter.setText("" + allcount);
                    Toast.makeText(getContext(), "go", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getContext(), "Again", Toast.LENGTH_SHORT).show();
                }
            }
        });


        // to back fragment to anther fragment
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new SabheFragment1();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container1, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }


}