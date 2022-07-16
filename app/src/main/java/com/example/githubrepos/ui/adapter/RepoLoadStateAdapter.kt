package com.example.githubrepos.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import com.example.githubrepos.databinding.ItemLoadingBinding

class ReposLoadStateAdapter(context: Context) : LoadStateAdapter<RepoLoadStateViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onBindViewHolder(holder: RepoLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): RepoLoadStateViewHolder =
        RepoLoadStateViewHolder(ItemLoadingBinding.inflate(layoutInflater, parent, false))
}