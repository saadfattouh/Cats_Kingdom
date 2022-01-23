package com.example.catkingdom.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.catkingdom.R;
import com.example.catkingdom.model.Book;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder>{

    Context context;
    private List<Book> books;
    String currentLang;

    // RecyclerView recyclerView;
    public BooksAdapter(Context context, List<Book> books) {
        this.context = context;
        this.books = books;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.book_list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);

        return viewHolder;
    }



    @Override
    public void onBindViewHolder(@NonNull BooksAdapter.ViewHolder holder, int position) {
        Book book = books.get(position);



        if(book.getImageUrl() == null){
            Glide.with(context)
                    .load(context.getResources().getDrawable(R.drawable.ic_image_icon))
                    .into(holder.bookImage);
        }else{
            Glide.with(context)
                    .load(book.getImageUrl())
                    .into(holder.bookImage);
        }

        holder.bookTitle.setText(book.getTitle());



    }

    @Override
    public int getItemCount() {
        return books.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView bookImage;
        public TextView bookTitle;

        public ViewHolder(View itemView) {
            super(itemView);
            this.bookImage = itemView.findViewById(R.id.book_image);
            this.bookTitle = itemView.findViewById(R.id.book_title);
        }
    }
}

