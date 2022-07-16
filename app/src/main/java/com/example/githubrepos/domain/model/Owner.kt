package com.example.githubrepos.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Owner(
    val avatarUrl: String,
    val login: String,
    val type: String,
): Parcelable
