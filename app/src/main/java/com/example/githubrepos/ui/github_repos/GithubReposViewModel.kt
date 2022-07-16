package com.example.githubrepos.ui.github_repos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.githubrepos.domain.model.Repo
import com.example.githubrepos.use_cases.GithubReposUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GithubReposViewModel: ViewModel(), KoinComponent {

    private val githubReposUseCase: GithubReposUseCase by inject()

    private var _repoPagingData = MutableStateFlow<PagingData<Repo>>(PagingData.empty())
    val repoPagingData: StateFlow<PagingData<Repo>> = _repoPagingData

    init {
        loadRepos()
    }

    private fun loadRepos() {
        viewModelScope.launch {
            githubReposUseCase.getPagedRepos().cachedIn(this).collectLatest {
                _repoPagingData.value = it
            }
        }
    }

}