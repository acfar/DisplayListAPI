package com.shuffle.maknews.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.shuffle.maknews.databinding.HeadlineItemBinding;
import com.shuffle.maknews.model.Article;

public class HeadlineViewHolder extends RecyclerView.ViewHolder {
    HeadlineItemBinding binding;

    public HeadlineViewHolder(@NonNull HeadlineItemBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void bind(Article article){
        binding.setArticle(article);
    }
}
