package com.example.appazkar.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appazkar.Adapter.DataAdabter;
import com.example.appazkar.Model.Datamodel;
import com.example.appazkar.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Datamodel> datamodels;
    Fragment fragment;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerviewCard);




        loadData();

        DataAdabter adabter = new DataAdabter(datamodels, new DataAdabter.OnDataItemClickListener() {
            @Override
            public Fragment OnItemClick(int position) {
                if (position == 0) {
                    Toast.makeText(getContext(), "1", Toast.LENGTH_SHORT).show();
                    fragment = new AzkarFragment1();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.add(R.id.fragment_container1, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();

                    return fragment;
                } else if (position == 1) {
                    fragment = new SabheFragment1();
                    FragmentTransaction transaction = getFragmentManager().beginTransaction();
                    transaction.add(R.id.fragment_container1, fragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                    return fragment;

                    /*
                    Toast.makeText(getContext(), "2", Toast.LENGTH_SHORT).show();
                    Fragment fragment1 =new Fragment1();
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container1,fragment1)
                            .commit();

                     */


                } else if (position == 2) {
                    Toast.makeText(getContext(), "3", Toast.LENGTH_SHORT).show();
                } else if (position == 3) {
                    Toast.makeText(getContext(), "4", Toast.LENGTH_SHORT).show();
                } else if (position == 4) {
                    Toast.makeText(getContext(), "5", Toast.LENGTH_SHORT).show();
                } else if (position == 5) {
                    Toast.makeText(getContext(), "6", Toast.LENGTH_SHORT).show();
                }

                return null;
            }

        });


        recyclerView.setAdapter(adabter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

    }


    private void loadData() {
        datamodels = new ArrayList<>();
        datamodels.add(new Datamodel(R.drawable.hands, "أذكار"));
        datamodels.add(new Datamodel(R.drawable.muslimsabah, "سبحه"));
        datamodels.add(new Datamodel(R.drawable.quranhol, "القرءان الكريم"));
        datamodels.add(new Datamodel(R.drawable.halal, "أحاديث"));
        datamodels.add(new Datamodel(R.drawable.quran, "اسماء الله الحسني"));
        datamodels.add(new Datamodel(R.drawable.ic_baseline_lock_24, "الرقيه الشرعيه"));
    }



}

