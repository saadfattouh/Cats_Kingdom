package com.example.catkingdom.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.catkingdom.R;
import com.example.catkingdom.adapters.BooksAdapter;
import com.example.catkingdom.model.Book;

import java.util.ArrayList;


public class LibraryFragment extends Fragment {

    public static final String TAG = "library";


    BooksAdapter mAdapter;
    ArrayList<Book> books;
    RecyclerView mBooksListView;


    public LibraryFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        books = new ArrayList<Book>()
        {{
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
            add(new Book("title", null));
        }};

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBooksListView = view.findViewById(R.id.books_list);

        mAdapter = new BooksAdapter(getContext(), books);

        GridLayoutManager gridManager = new GridLayoutManager(getContext(), 3, GridLayoutManager.VERTICAL, false);

        mBooksListView.setLayoutManager(gridManager);
        mBooksListView.setAdapter(mAdapter);

    }
}