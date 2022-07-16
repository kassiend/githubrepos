package com.example.githubrepos.data.modes

import com.example.githubrepos.domain.model.Owner

data class OwnerEntity(
    val avatarUrl: String,
    val login: String,
    val type: String,
)

// Better move to mapper class
fun OwnerEntity.toDomain() = Owner(
    avatarUrl,
    login,
    type,
)