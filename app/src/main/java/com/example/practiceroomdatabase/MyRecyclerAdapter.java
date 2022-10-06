package com.example.practiceroomdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    Context context;
    List<MyModelClass> myModelClassList;

    public MyRecyclerAdapter(Context context, List<MyModelClass> myModelClassList) {
        this.context = context;
        this.myModelClassList = myModelClassList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.titleName.setText(myModelClassList.get(position).getTitleName());
        holder.amountValue.setText(myModelClassList.get(position).getAmountName());
    }

    @Override
    public int getItemCount() {
        return myModelClassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView titleName, amountValue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            titleName = itemView.findViewById(R.id.titleName);
            amountValue = itemView.findViewById(R.id.amountValue);

        }
    }
}
