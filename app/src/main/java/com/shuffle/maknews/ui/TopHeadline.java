package com.shuffle.maknews.ui;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.shuffle.maknews.R;
import com.shuffle.maknews.adapter.HeadlineAdapter;
import com.shuffle.maknews.databinding.ActivityTopHeadlineBinding;
import com.shuffle.maknews.model.Article;
import com.shuffle.maknews.model.Results;
import com.shuffle.maknews.network.ApiClient;
import com.shuffle.maknews.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TopHeadline extends AppCompatActivity {
    HeadlineAdapter adapter;
    ActivityTopHeadlineBinding binding;


    private final String TAG = TopHeadline.class.getSimpleName();

    private void initList() {
//        adapter = new HeadlineAdapter(new ArrayList<Article>());
////        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
////        this.binding.mainRcvItem.setLayoutManager(layoutManager);
////        this.binding.mainRcvItem.setAdapter(adapter);
//        user.add(new Article("Achmad","Fauzi","Rachmani"));
//        adapter = new HeadlineAdapter(user);
//        binding.setAdapter(adapter);
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_top_headline);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_top_headline);
//        initList();
        loadArticlesAsync("us","833123c7035645d6860069138bd33449");
    }

    private void loadArticlesAsync(String country, String apiKey){
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
//        Call<UserResponse> call = apiInterface.getTopRatedMovies(result);
        Call<Results> call = apiInterface.getArticles(country,apiKey);
        call.enqueue(new Callback<Results>() {
            @Override
            public void onResponse(Call<Results> call, Response<Results> response) {
                Results results = response.body();
                showData(results);
            }

            @Override
            public void onFailure(Call<Results> call, Throwable t) {
                Log.d(TAG, t.toString());
            }
        });

    }

    private void showData(Results results) {
        adapter = new HeadlineAdapter(results.getArticles());
        binding.setAdapter(adapter);
    }
}
