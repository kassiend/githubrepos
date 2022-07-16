package com.example.githubrepos.domain

import retrofit2.http.GET
import retrofit2.http.Query

interface GithubRepository {

    suspend fun fetchData()
}