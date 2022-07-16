package com.example.githubrepos.di

import com.example.githubrepos.ui.github_repos.GithubReposViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun getViewModels() = module {
    viewModel { GithubReposViewModel() }
}