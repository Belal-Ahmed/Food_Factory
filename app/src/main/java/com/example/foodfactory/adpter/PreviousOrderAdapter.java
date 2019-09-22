package com.example.foodfactory.adpter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodfactory.R;

public class PreviousOrderAdapter extends RecyclerView.Adapter<PreviousOrderAdapter.MyViewHolder> {
    private static final String TAG = "PreviousOrderAdapter";
    private Context preContext;
    private String[] previousOrderList;

    public PreviousOrderAdapter(Context preContext, String[] previousOrderList) {
        this.preContext = preContext;
        this.previousOrderList = previousOrderList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.d(TAG, "onCreateViewHolder: in onCreateViewHolder");
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.previous_order_view,parent,false);
        return new PreviousOrderAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: in onBindViewHolder");
        holder.orderList.setText(previousOrderList[position]);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: in getItemCount");
        return previousOrderList.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView orderComplete,orderCompleteTime, orderCompleteId, orderList, total;
        ImageView previousOrderItemImage;
        Button previousOrderRate, previousOrderReorder;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            Log.d(TAG, "MyViewHolder: initializing wiz");

            //initializing wiz
            orderComplete = itemView.findViewById(R.id.order_completed_tv);
            orderCompleteTime = itemView.findViewById(R.id.order_completed_time_tv);
            orderCompleteId = itemView.findViewById(R.id.order_id_tv);
            orderList = itemView.findViewById(R.id.previous_order_item_tv);
            total = itemView.findViewById(R.id.reorder_total_tv);

            previousOrderItemImage = itemView.findViewById(R.id.previous_order_item_iv);
            previousOrderRate = itemView.findViewById(R.id.previous_order_rate_btn);
            previousOrderReorder = itemView.findViewById(R.id.previous_order_reorder_btn);

        }
    }
}
