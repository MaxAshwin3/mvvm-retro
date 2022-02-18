package com.example.movielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.movielist.Adapter.MovieListAdapter;
import com.example.movielist.model.MovieModel;
import com.example.movielist.viewModel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MovieListAdapter adapter;
    List<MovieModel> list;
    MovieListViewModel model;
    TextView txtView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(linearLayoutManager);
         adapter = new MovieListAdapter(list,this);
        recyclerView.setAdapter(adapter);
        txtView = findViewById(R.id.noreslt);



         model =ViewModelProviders.of(this).get(MovieListViewModel.class);

         model.getMovieListObserver().observe(this, new Observer<List<MovieModel>>() {
             @Override
             public void onChanged(List<MovieModel> movieModels) {
                 if(movieModels != null)
                 {
                     list = movieModels;
                     adapter.setList(movieModels);
                     txtView.setVisibility(View.GONE);
                 }
                 else
                 {
                     txtView.setVisibility(View.VISIBLE);

                 }
             }
         });
        model.makeApiCall();
    }
}