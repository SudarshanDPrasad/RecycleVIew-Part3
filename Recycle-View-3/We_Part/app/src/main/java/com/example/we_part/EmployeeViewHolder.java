package com.example.we_part;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
    private TextView mTvName;
    private TextView mTvAge;
    private TextView mTvAddress;
    private ImageView mIvEdit;


    public EmployeeViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
        super(itemView);
        intidviews(itemView);
    }

    private void intidviews(View itemView) {
        mIvEdit = itemView.findViewById(R.id.ivEdit);
        mTvAddress = itemView.findViewById(R.id.tvAddress);
        mTvAge = itemView.findViewById(R.id.tvAge);
        mTvName = itemView.findViewById(R.id.tvName);

    }

    public void setData(Employee employee, ItemClickListener itemClickListener) {
        mTvName.setText(employee.getName());
        mTvAge.setText(employee.getAge() + " ");
        mTvAddress.setText(employee.getAddress());

        mIvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClicked(getAdapterPosition(), employee);
            }
        });
    }
}
