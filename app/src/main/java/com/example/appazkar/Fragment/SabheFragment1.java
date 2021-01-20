package com.example.appazkar.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.appazkar.Adapter.SabaheAdabter;
import com.example.appazkar.Model.Sabhe;
import com.example.appazkar.R;

import java.util.ArrayList;

public class SabheFragment1 extends Fragment {


    //                                                    السبحه الالكترونيه

    public SabheFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sabhe_fragment1, container, false);
    }


    private RecyclerView recyclerView;
    private ArrayList<Sabhe> sabhes;
    private ImageView backBtn;



    Fragment fragment;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView_azkar_sabh);
        backBtn = view.findViewById(R.id.back_pressed);


        loadAzkar();

        SabaheAdabter azkarAdabter = new SabaheAdabter(sabhes, new SabaheAdabter.OnAzkarItemClickListener() {
            @Override
            public void OnItemClick(int position,Sabhe sabhe ) {
                Toast.makeText(getContext(), "welcome", Toast.LENGTH_SHORT).show();
                fragment = new SabheFragment2();
                //     send data fragment anther fragment
                Bundle args = new Bundle();
                String value = sabhe.getAzkarText();
                args.putString("Ahmed",value);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.fragment_container1, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                fragment.setArguments(args);


            }

        });




        // to back fragment to anther fragment

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new HomeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.fragment_container1, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(azkarAdabter);

    }

    public void loadAzkar() {
        sabhes = new ArrayList<>();
        sabhes.add(new Sabhe("أستغفر الله"));
        sabhes.add(new Sabhe("الحمد لله رب العالمين"));
        sabhes.add(new Sabhe("الحمد لله حمدا كثيرا طيبا مباركا فيه"));
        sabhes.add(new Sabhe("أالله اكبر"));
        sabhes.add(new Sabhe("اللهم صلي وسلم علي سيدنا محمد "));
        sabhes.add(new Sabhe("سبحان الله"));

    }

}
