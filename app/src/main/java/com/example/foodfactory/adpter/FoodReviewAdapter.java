package com.example.foodfactory.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodfactory.R;
import com.example.foodfactory.all_interface.FoodReviewListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class FoodReviewAdapter extends RecyclerView.Adapter<FoodReviewAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<String> foodArrayList = new ArrayList<>();

    public FoodReviewAdapter(Context mContext, ArrayList<String> foodArrayList) {
        this.mContext = mContext;
        this.foodArrayList = foodArrayList;
    }

    private FoodReviewListener foodReviewListener;

    public void setFoodReviewListener(FoodReviewListener foodReviewListener) {
        this.foodReviewListener = foodReviewListener;
    }

    public void setFoodArrayList(ArrayList<String> foodArrayList) {
        this.foodArrayList = foodArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.user_review_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //set Animation
        holder.reviewerIv.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation));
        holder.reviewerNameTv.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));
        holder.reviewerReviewTv.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));
        final String name = foodArrayList.get(position);
        holder.reviewerNameTv.setText(name);

        holder.reviewerIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (foodReviewListener != null) {
                    foodReviewListener.didPressed(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.reviewer_iv)
        CircleImageView reviewerIv;
        @BindView(R.id.reviewer_name_tv)
        TextView reviewerNameTv;
        @BindView(R.id.reviewer_review_tv)
        TextView reviewerReviewTv;
        @BindView(R.id.reviewer_rb)
        RatingBar reviewerRb;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
