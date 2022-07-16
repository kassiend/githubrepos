package com.example.githubrepos.use_cases

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.githubrepos.domain.model.Repo
import com.example.githubrepos.domain.paging.GithubPagingSource
import kotlinx.coroutines.flow.Flow

class GithubReposUseCase {

    fun getPagedRepos(): Flow<PagingData<Repo>> {
        return Pager(
            config = PagingConfig(
                pageSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { GithubPagingSource() }
        ).flow
    }
}