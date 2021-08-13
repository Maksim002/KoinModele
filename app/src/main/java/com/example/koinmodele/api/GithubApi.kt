package com.example.android_di_koin_example.api

import com.example.android_di_koin_example.model.GithubAccount
import com.example.testkoin.model.ExampleModel
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubApi {
    @GET("v1/countries?")
    suspend fun news(): Response<ExampleModel>
}