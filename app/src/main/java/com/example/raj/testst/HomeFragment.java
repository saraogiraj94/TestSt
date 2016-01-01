package com.example.raj.testst;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;
    String name[];
    ArrayList<MainCard> list=new ArrayList<MainCard>();
    int[] image_id={R.drawable.packing_material,R.drawable.marker_pen,R.drawable.wool_fabric,R.drawable.felt_cloth,R.drawable.stationary};
    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        name=getResources().getStringArray(R.array.main);
        int ctr=0;
        for (String Name : name){
            MainCard mainCard=new MainCard(image_id[ctr],Name);
            ctr++;
            list.add(mainCard);
        }
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView=(RecyclerView)rootView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        adapter=new MainCardAdapter(list,this);
        recyclerView.setAdapter(adapter);
        return rootView;

    }


}
