package com.example.movielist.Network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    public static String Base_Url = "https://jsonplaceholder.typicode.com/";
    private static Retrofit retrofit;
    public static Retrofit getRetroClient ()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                       .baseUrl(Base_Url)
                       .addConverterFactory(GsonConverterFactory.create())
                       .build();
        }
        return retrofit;
    }
}
