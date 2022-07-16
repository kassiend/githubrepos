package com.example.githubrepos.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Repo(
    val fullName: String?,
    val description: String?,
    val owner: Owner?,
    val stargazersCount: Int?,
): Parcelable
