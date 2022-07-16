package com.example.githubrepos.data.sources

import com.example.githubrepos.data.modes.response.RepoPageEntity
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {

    @GET("search/repositories?sort=stars&order=desc")
    suspend fun getLatestRepos(
        @Query("q") lastDate: String,
        @Query("page") page: Int,
    ): RepoPageEntity

}