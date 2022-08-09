package com.example.arcadia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)
        introPlayBtn.setOnClickListener {
            onClickPlayButton()
        }
    }

    private fun onClickPlayButton() {
        val intent = Intent(this, MainMenuActivity::class.java)
        startActivity(intent)
    }
}