package com.example.githubrepos.di

import com.example.githubrepos.data.GithubRepositoryImpl
import com.example.githubrepos.domain.GithubRepository
import org.koin.dsl.module

fun getRepositoryModule() = module {
    single<GithubRepository> { GithubRepositoryImpl() }
}
