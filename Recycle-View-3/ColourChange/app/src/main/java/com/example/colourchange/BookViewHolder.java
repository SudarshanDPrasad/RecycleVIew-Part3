package com.example.colourchange;

import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

public class BookViewHolder extends RecyclerView.ViewHolder {
    private Button mbtnclick;
    private RelativeLayout relativeLayout;

    public BookViewHolder(@NonNull View itemView) {
        super(itemView);
        intidviews(itemView);
    }

    private void intidviews(View itemView) {
        mbtnclick = itemView.findViewById(R.id.btnclick);
        relativeLayout = itemView.findViewById(R.id.relativelayout);
    }

    public void setData(Books books, ItemOnClick itemOnClick) {
        mbtnclick.setText(books.getName());

        if (books.isSelected()) {
            mbtnclick.setBackgroundColor(ContextCompat.getColor(relativeLayout.getContext(),R.color.blue));
            mbtnclick.setTextColor(ContextCompat.getColor(relativeLayout.getContext(),R.color.white));
        } else {
            mbtnclick.setBackgroundColor(ContextCompat.getColor(relativeLayout.getContext(),R.color.white));
            mbtnclick.setTextColor(ContextCompat.getColor(relativeLayout.getContext(),R.color.blue));

        }

        mbtnclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemOnClick.onCLick(getAdapterPosition(), books);
            }
        });

    }
}
