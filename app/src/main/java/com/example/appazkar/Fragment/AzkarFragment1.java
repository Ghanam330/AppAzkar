package com.example.appazkar.Fragment;

import android.app.ProgressDialog;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appazkar.Adapter.AzkarAdapter;
import com.example.appazkar.Model.AzkarName;
import com.example.appazkar.R;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class AzkarFragment1 extends Fragment {
    Fragment fragment;
    private RecyclerView recyclerView;
    AzkarAdapter adapter;
    private ImageView btn_back;
    ProgressDialog progress;

    public AzkarFragment1() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_azkar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerView_azkar_sabh);
        btn_back = view.findViewById(R.id.back_pressed);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        recyclerView.setLayoutManager(gridLayoutManager);

        FirebaseRecyclerOptions<AzkarName> options
                = new FirebaseRecyclerOptions.Builder<AzkarName>()
                .setQuery(FirebaseDatabase.getInstance().getReference().child("الاذكار"), AzkarName.class)
                .build();



        adapter = new AzkarAdapter(options, new AzkarAdapter.OnAzkarItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                Toast.makeText(getContext(), "Welcom", Toast.LENGTH_SHORT).show();

           //  دي لسه مجربتهاش  لما اصحي ابقي جربها

                fragment = new AzkarDetailsFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.fragment_container1, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                Bundle bundle=new Bundle();
                bundle.putString("id",adapter.getRef(position).getKey());

               AzkarFragment1 fragobj=new AzkarFragment1();
                fragobj.setArguments(bundle);

            }
        });


        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment = new HomeFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.add(R.id.fragment_container1, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        int itemMargin = 10;
        int numColumns = 5;
       RecyclerViewMargin decoration = new RecyclerViewMargin(itemMargin, numColumns);
        recyclerView.addItemDecoration(decoration);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onStart() {
        super.onStart();
        adapter.startListening();
    }
    @Override
    public void onStop() {
        super.onStop();
        adapter.stopListening();
    }




    public class RecyclerViewMargin extends RecyclerView.ItemDecoration {
        private final int columns;
        private int margin;

        /**
         * constructor
         * @param margin desirable margin size in px between the views in the recyclerView
         * @param columns number of columns of the RecyclerView
         */
        public RecyclerViewMargin(@IntRange(from=5)int margin , @IntRange(from=5) int columns ) {
            this.margin = margin;
            this.columns=columns;

        }

        /**
         * Set different margins for the items inside the recyclerView: no top margin for the first row
         * and no left margin for the first column.
         */
        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {

            int position = parent.getChildLayoutPosition(view);
            //set right margin to all
            outRect.right = margin;
            //set bottom margin to all
            outRect.bottom = margin;
            //we only add top margin to the first row
            if (position <columns) {
                outRect.top = margin;
            }
            //add left margin only to the first column
            if(position%columns==0){
                outRect.left = margin;
            }
        }
    }
}
