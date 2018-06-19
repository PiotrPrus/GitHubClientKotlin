package com.example.piotrprus.githubclientkotlin.network

import com.example.piotrprus.githubclientkotlin.model.RepositoriesResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApi {
    @GET("/search/repositories")
    fun searchRpositories(@Query("q") query: String): Call<RepositoriesResponse>
}