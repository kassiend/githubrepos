package com.example.githubrepos.di

import com.example.githubrepos.data.GithubRepositoryImpl
import com.example.githubrepos.domain.GithubRepository
import org.koin.dsl.module

internal fun getRepositoryModule() = module {
    single<GithubRepository> { GithubRepositoryImpl() }
}
