package com.example.githubrepos.domain.model

data class RepoPage(
    val totalCount: Int?,
    val incompleteResults: Boolean?,
    val items: List<Repo>,
)