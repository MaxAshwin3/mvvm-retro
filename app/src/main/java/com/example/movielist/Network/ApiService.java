package com.example.movielist.Network;

import com.example.movielist.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    @GET("posts")
    
    Call<List<MovieModel>> getMovieList ();


}
