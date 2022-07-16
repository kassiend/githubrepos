package com.example.githubrepos.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.githubrepos.databinding.ItemRepoBinding
import com.example.githubrepos.domain.model.Repo

class RepoListAdapter(context: Context) :
    PagingDataAdapter<Repo, RepoItemViewHolder>(REPO_DIFF_UTIL) {

    private val layoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoItemViewHolder {
        return RepoItemViewHolder(ItemRepoBinding.inflate(layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: RepoItemViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
    }

    companion object {
        private val REPO_DIFF_UTIL = object : DiffUtil.ItemCallback<Repo>() {
            override fun areItemsTheSame(oldItem: Repo, newItem: Repo): Boolean {
                return oldItem.fullName == newItem.fullName ||
                        oldItem.description == newItem.description
            }

            override fun areContentsTheSame(oldItem: Repo, newItem: Repo): Boolean =
                oldItem == newItem
        }
    }
}
