package com.example.piotrprus.githubclientkotlin.model

import com.google.gson.annotations.SerializedName

class Repository(val name: String?, val description: String?, @SerializedName("html_url") val url: String?, @SerializedName("stargazers_count") val stars: Int?)