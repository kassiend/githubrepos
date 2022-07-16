package com.example.githubrepos.domain

import com.example.githubrepos.domain.model.RepoPage

interface GithubRepository {

    suspend fun fetchData(page: Int): RepoPage
}