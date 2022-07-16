package com.example.githubrepos.data

import com.example.githubrepos.common.getLastMonth
import com.example.githubrepos.data.modes.response.toDomain
import com.example.githubrepos.data.sources.GithubApi
import com.example.githubrepos.domain.GithubRepository
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GithubRepositoryImpl : GithubRepository, KoinComponent {

    private val githubApi: GithubApi by inject()

    override suspend fun fetchData(page: Int) =
        githubApi.getLatestRepos(getLastMonth(), page).toDomain()
}