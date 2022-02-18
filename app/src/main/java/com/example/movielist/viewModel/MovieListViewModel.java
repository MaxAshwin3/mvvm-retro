package com.example.movielist.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.movielist.Network.ApiService;
import com.example.movielist.Network.RetroInstance;
import com.example.movielist.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListViewModel extends ViewModel {

    private MutableLiveData<List<MovieModel>> movieList;

    public MovieListViewModel() {
        movieList = new MutableLiveData<>();
    }
    public MutableLiveData<List<MovieModel>> getMovieListObserver()
    {
        return movieList;
    }

    public void makeApiCall()
    {
        ApiService apiService = RetroInstance.getRetroClient().create(ApiService.class);
        Call<List<MovieModel>> call = apiService.getMovieList();
        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                 movieList.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                movieList.postValue(null);
            }
        });
    }
}
