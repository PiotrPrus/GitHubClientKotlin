package com.example.piotrprus.githubclientkotlin.screen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.piotrprus.githubclientkotlin.R
import kotlinx.android.synthetic.main.activity_screen.*

class ScreenActivity : AppCompatActivity() {

    val adapter = Adapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen)

        screen_recycler_view.adapter = adapter
    }
}
