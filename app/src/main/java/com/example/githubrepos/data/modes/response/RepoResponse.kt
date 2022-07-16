package com.example.githubrepos.data.modes.response

import com.example.githubrepos.data.modes.RepoEntity

data class RepoResponse(
    val totalCount: Int?,
    val incompleteResults: Boolean?,
    val items: List<RepoEntity>,
)
