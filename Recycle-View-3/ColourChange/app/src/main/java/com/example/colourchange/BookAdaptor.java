package com.example.colourchange;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdaptor extends RecyclerView.Adapter<BookViewHolder> {
    private ArrayList<Books> booksArrayList;
    private ItemOnClick itemOnClick;

    public BookAdaptor(ArrayList<Books> booksArrayList,ItemOnClick itemOnClick) {
        this.booksArrayList = booksArrayList;
        this.itemOnClick = itemOnClick;

    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layou, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Books books = booksArrayList.get(position);
        holder.setData(books,itemOnClick);

    }

    @Override
    public int getItemCount() {
        return booksArrayList.size();
    }
}
