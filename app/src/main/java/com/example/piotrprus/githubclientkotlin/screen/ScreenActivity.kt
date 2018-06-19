package com.example.piotrprus.githubclientkotlin.screen

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.piotrprus.githubclientkotlin.R
import com.example.piotrprus.githubclientkotlin.network.GithubApi
import com.example.piotrprus.githubclientkotlin.onTextChanged
import kotlinx.android.synthetic.main.activity_screen.*
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.CoroutineStart
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ScreenActivity : AppCompatActivity() {

    val adapter = Adapter()

    private val api: GithubApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        api = retrofit.create(GithubApi::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)

        screen_recycler_view.adapter = adapter
        search_edit_text.onTextChanged { text: String -> searchGithub(text) }
    }

    fun searchGithub(text: String) {
        screen_progress_bar.visibility = View.VISIBLE

        launch(CommonPool) {
            try {
                val response = api.searchRpositories(text).execute().body()

                withContext(UI, CoroutineStart.DEFAULT, {
                    screen_progress_bar.visibility = View.GONE

                    val repositories = response?.repositories
                    repositories?.let { adapter.setRepositories(repositories) }
                })
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
