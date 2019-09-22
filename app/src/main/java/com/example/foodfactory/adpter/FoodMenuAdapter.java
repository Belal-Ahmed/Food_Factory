package com.example.foodfactory.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodfactory.R;
import com.example.foodfactory.all_interface.FoodMenuListener;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodMenuAdapter extends RecyclerView.Adapter<FoodMenuAdapter.ViewHolder> {


    private Context mContext;
    private ArrayList<String> foodArrayList = new ArrayList<>();

    public FoodMenuAdapter(Context mContext, ArrayList<String> foodArrayList) {
        this.mContext = mContext;
        this.foodArrayList = foodArrayList;
    }

    private FoodMenuListener foodMenuListener;

    public void setAdapterListener(FoodMenuListener foodMenuListener) {
        this.foodMenuListener = foodMenuListener;
    }

    public void setFoodArrayList(ArrayList<String> foodArrayList) {
        this.foodArrayList = foodArrayList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.menu_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        //set Animation
        holder.menuImageId.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_transition_animation));
        holder.menuTitleId.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));
        holder.menuPizeId.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));
        holder.menuAddBtn.setAnimation(AnimationUtils.loadAnimation(mContext, R.anim.fade_scale_animation));
        final String name = foodArrayList.get(position);
        holder.menuTitleId.setText(name);

        holder.menuImageId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (foodMenuListener != null) {
                    foodMenuListener.didPressed(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.menuImageId)
        ImageView menuImageId;
        @BindView(R.id.menuTitleId)
        TextView menuTitleId;
        @BindView(R.id.menuPizeId)
        TextView menuPizeId;
        @BindView(R.id.menuWishlistId)
        ImageView menuWishlistId;
        @BindView(R.id.menuMinusIcon)
        TextView menuMinusIcon;
        @BindView(R.id.menuValueId)
        TextView menuValueId;
        @BindView(R.id.menuPlusIcon)
        TextView menuPlusIcon;
        @BindView(R.id.menuAddBtn)
        Button menuAddBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
