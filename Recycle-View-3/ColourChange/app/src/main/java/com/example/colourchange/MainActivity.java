package com.example.colourchange;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemOnClick{

    private RecyclerView recyclerView;
    private ArrayList<Books> booksArrayList = new ArrayList<>();
    private BookAdaptor bookAdaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intidviews();
        buildview();
        setrecycleview();
    }

    private void setrecycleview() {
         bookAdaptor = new BookAdaptor(booksArrayList,this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(bookAdaptor);
    }

    private void buildview() {
        booksArrayList = new ArrayList<>();
        booksArrayList.add(new Books("Books", false));
        booksArrayList.add(new Books("Podcast", false));
        booksArrayList.add(new Books("Abhiram", false));
        booksArrayList.add(new Books("noida", false));
        booksArrayList.add(new Books("kithab", false));
        booksArrayList.add(new Books("naaavea", false));
        booksArrayList.add(new Books("yesitsdone", false));
        booksArrayList.add(new Books("yesitsdone", false));
        booksArrayList.add(new Books("yesitsdone", false));
        booksArrayList.add(new Books("yesitsdone", false));
    }

    private void intidviews() {
        recyclerView = findViewById(R.id.recycleview);
    }


    @Override
    public void onCLick(int position, Books books) {
        Books update_new;

        if(books.isSelected()){
            update_new = new Books(books.getName(),false);
        }else{
            update_new = new Books(books.getName(),true);
        }

        booksArrayList.set(position,update_new);
        bookAdaptor.notifyDataSetChanged();
    }
}