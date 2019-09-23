package com.example.foodfactory.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodfactory.R;
import com.example.foodfactory.adpter.NearByRestaurantAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

import static androidx.constraintlayout.widget.Constraints.TAG;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    @BindView(R.id.home_toolbar)
    Toolbar homeToolbar;
    @BindView(R.id.search_la)
    LinearLayout searchLa;
    @BindView(R.id.homeLocation)
    TextView homeLocation;
    @BindView(R.id.homeSearch)
    EditText homeSearch;
    @BindView(R.id.all_restaurant_rv)
    RecyclerView allRestaurantRv;
    private String[] allrestaurantName_list;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        allrestaurantName_list = getResources().getStringArray(R.array.restaurant_list);
        Log.d(TAG, "onCreateView: " + allRestaurantRv);
        allRestaurantRv.setHasFixedSize(true);
        allRestaurantRv.setLayoutManager(new LinearLayoutManager(getActivity()));

        NearByRestaurantAdapter adapter = new NearByRestaurantAdapter(getActivity(), allrestaurantName_list);
        allRestaurantRv.setAdapter(adapter);
        return view;
    }

}
