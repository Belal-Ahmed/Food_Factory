package com.example.foodfactory.adpter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodfactory.R;
import com.example.foodfactory.activity.FoodMenuActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class NearByRestaurantAdapter extends RecyclerView.Adapter<NearByRestaurantAdapter.MyViewHolder> {
    private static final String TAG = "NearByRestaurantAdapter";


    private String[] restaurant_list;
    private Context nearBycontext;

    public NearByRestaurantAdapter(Context nearBycontext, String[] restaurant_list) {

        this.nearBycontext = nearBycontext;
        this.restaurant_list = restaurant_list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d(TAG, "onCreateViewHolder: in onCreateViewHolder");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.all_restaurant_view, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: in onBindViewHolder");
        holder.restaurantNameTv.setText(restaurant_list[position]);

        holder.restaurantMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(nearBycontext, FoodMenuActivity.class);
                nearBycontext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: in getItemCount");
        return restaurant_list.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.restaurant_logo_iv)
        ImageView restaurantLogoIv;
        @BindView(R.id.restaurant_name_tv)
        TextView restaurantNameTv;
        @BindView(R.id.restaurant_main_item_tv)
        TextView restaurantMainItemTv;
        @BindView(R.id.restaurant_menu_btn)
        Button restaurantMenuBtn;
        @BindView(R.id.restaurant_info_lo_01)
        LinearLayout restaurantInfoLo01;
        @BindView(R.id.restaurant_main_item_iv)
        ImageView restaurantMainItemIv;
        @BindView(R.id.favorite_tv)
        TextView favoriteTv;
        @BindView(R.id.rating_tv)
        TextView ratingTv;
        @BindView(R.id.open_close_tv)
        TextView openCloseTv;
        @BindView(R.id.all_restaurant_cv)
        CardView allRestaurantCv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "ViewHolder: in view Holder");
            ButterKnife.bind(this, itemView);

        }
    }
}
