package com.example.githubrepos.data.modes

import com.example.githubrepos.domain.model.Repo

data class RepoEntity(
    val fullName: String?,
    val description: String?,
    val owner: OwnerEntity?,
    val stargazersCount: Int?,
)

// Better move to mapper class
fun RepoEntity.toDomain() = Repo(
    fullName,
    description,
    owner?.toDomain(),
    stargazersCount,
)