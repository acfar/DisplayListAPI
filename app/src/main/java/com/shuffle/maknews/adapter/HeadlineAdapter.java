package com.shuffle.maknews.adapter;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.shuffle.maknews.R;
import com.shuffle.maknews.databinding.HeadlineItemBinding;
import com.shuffle.maknews.model.Article;

import java.util.List;

public class HeadlineAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Article> articles;

    public HeadlineAdapter(List<Article> articles) {
        this.articles = articles;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        HeadlineItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),
                R.layout.headline_item, viewGroup,
                false);
        return new HeadlineViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        HeadlineViewHolder headlineViewHolder = (HeadlineViewHolder) viewHolder;
        headlineViewHolder.bind(articles.get(position));
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
