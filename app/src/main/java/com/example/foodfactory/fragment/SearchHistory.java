package com.example.foodfactory.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodfactory.R;
import com.example.foodfactory.adpter.NearByRestaurantAdapter;
import com.example.foodfactory.adpter.PreviousOrderAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchHistory extends Fragment {
    private RecyclerView previousOrderRecyclerView;
    private String[] previousOrderList;

    public SearchHistory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search_history, container, false);
        previousOrderRecyclerView = view.findViewById(R.id.previous_order_rv);
        previousOrderList = getResources().getStringArray(R.array.previous_order_list);
        previousOrderRecyclerView.setHasFixedSize(true);
        previousOrderRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        PreviousOrderAdapter adapter = new PreviousOrderAdapter(getActivity(), previousOrderList);
        previousOrderRecyclerView.setAdapter(adapter);
        return view;
    }

}
