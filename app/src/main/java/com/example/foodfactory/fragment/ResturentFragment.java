package com.example.foodfactory.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodfactory.R;
import com.example.foodfactory.adpter.FoodMenuAdapter;
import com.example.foodfactory.all_interface.FoodMenuListener;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ResturentFragment extends Fragment {
    ArrayList<String> title = new ArrayList<>();
    FoodMenuAdapter foodMenuAdapter;

    Context context;
    @BindView(R.id.foodMenuRecyView)
    RecyclerView foodMenuRecyView;

    public ResturentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resturent, container, false);
        ButterKnife.bind(this,view);
        context = getActivity();

        // set adapter
        //setAdapter(context);
        title.clear();
        for (int i = 0; i < 15; i++) {
            title.add("Spicy Berger" + i);
        }
        foodMenuRecyView.setHasFixedSize(true);
        foodMenuRecyView.setLayoutManager(new LinearLayoutManager(context));
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

        foodMenuAdapter = new FoodMenuAdapter(context, title);
        foodMenuRecyView.setAdapter(foodMenuAdapter);
       // foodMenuRecyView.notifyAll();
        // set listener
        foodMenuAdapter.setAdapterListener(new FoodMenuListener() {
            @Override
            public void didPressed(int position) {
                Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        return view;

    }

    private void setAdapter(Context ctx) {
        title.clear();
        for (int i = 0; i < 15; i++) {
            title.add("Spicy Berger" + i);
        }
        foodMenuRecyView.setHasFixedSize(true);
        foodMenuRecyView.setLayoutManager(new LinearLayoutManager(ctx));
        //LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);

        foodMenuAdapter = new FoodMenuAdapter(ctx, title);
        foodMenuRecyView.setAdapter(foodMenuAdapter);
        foodMenuRecyView.notifyAll();
        // set listener
        foodMenuAdapter.setAdapterListener(new FoodMenuListener() {
            @Override
            public void didPressed(int position) {
                Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }

}
