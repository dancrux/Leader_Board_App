package com.cruxrepublic.leader.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.cruxrepublic.leader.MainActivity
import com.cruxrepublic.leader.R

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 3000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
        }, SPLASH_TIME_OUT)
    }
}