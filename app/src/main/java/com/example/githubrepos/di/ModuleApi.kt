package com.example.githubrepos.di

import com.example.githubrepos.data.sources.GithubApi
import org.koin.dsl.module
import retrofit2.Retrofit

fun getApiModule() = module {
    single { get<Retrofit>().create(GithubApi::class.java) }
}