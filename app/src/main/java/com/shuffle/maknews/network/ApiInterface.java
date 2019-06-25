package com.shuffle.maknews.network;

import com.shuffle.maknews.model.Results;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("top-headlines")
    Call<Results> getArticles(@Query("country") String country, @Query("apiKey") String apiKey);

}
