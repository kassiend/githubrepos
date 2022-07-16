package com.example.githubrepos.data.modes.response

import com.example.githubrepos.data.modes.RepoEntity
import com.example.githubrepos.data.modes.toDomain
import com.example.githubrepos.domain.model.RepoPage

data class RepoPageEntity(
    val totalCount: Int?,
    val incompleteResults: Boolean?,
    val items: List<RepoEntity>,
)

fun RepoPageEntity.toDomain() = RepoPage(
    totalCount,
    incompleteResults,
    items.map { it.toDomain() }
)