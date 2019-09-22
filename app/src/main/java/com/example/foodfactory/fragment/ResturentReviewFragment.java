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
import com.example.foodfactory.adpter.FoodReviewAdapter;
import com.example.foodfactory.all_interface.FoodReviewListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResturentReviewFragment extends Fragment {
    ArrayList<String> title = new ArrayList<>();
    FoodReviewAdapter foodReviewAdapter;

    Context context;
    @BindView(R.id.foodReviewRecyView)
    RecyclerView foodReviewRecyView;

    public ResturentReviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resturent_review, container, false);
        ButterKnife.bind(this, view);
        context = getActivity();
        setAdapter(context);
        return view;
    }

    private void setAdapter(Context ctx) {
        title.clear();
        for (int i = 0; i < 15; i++) {
            title.add("Spicy Berger" + i);
        }
        foodReviewRecyView.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        foodReviewRecyView.setLayoutManager(linearLayoutManager);
        foodReviewAdapter = new FoodReviewAdapter(ctx, title);
        foodReviewRecyView.setAdapter(foodReviewAdapter);
        // foodMenuRecyView.notifyAll();
        //
        // set listener
        foodReviewAdapter.setFoodReviewListener(new FoodReviewListener() {
            @Override
            public void didPressed(int position) {
                Toast.makeText(getActivity(), "" + position, Toast.LENGTH_SHORT).show();
            }
        });

    }
}
