package com.example.githubrepos.di

import com.example.githubrepos.use_cases.GithubReposUseCase
import org.koin.dsl.module

fun getUseCases() = module {
    single { GithubReposUseCase() }
}