package com.example.githubrepos.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.githubrepos.databinding.ItemRepoBinding
import com.example.githubrepos.domain.model.Repo

class RepoItemViewHolder(private val itemBinding: ItemRepoBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(repo: Repo) {
        itemBinding.apply {
            ivAvatar.load(repo.owner?.avatarUrl)
            tvUserName.text = repo.owner?.login
            tvRepoName.text = repo.fullName ?: "Empty name repo"
            tvRepoDesc.text = repo.description ?: "Empty description repo"
            tvRepoStarCnt.text = (repo.stargazersCount ?: 0).toString()
        }
    }
}