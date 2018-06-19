package com.example.piotrprus.githubclientkotlin.model

import com.google.gson.annotations.SerializedName

class RepositoriesResponse(@SerializedName("items") val repositories: Collection<Repository>)