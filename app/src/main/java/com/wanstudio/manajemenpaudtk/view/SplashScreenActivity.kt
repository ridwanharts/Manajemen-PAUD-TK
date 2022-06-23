package com.wanstudio.manajemenpaudtk.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wanstudio.manajemenpaudtk.R

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val i = Intent(this, MainActivity::class.java)
        startActivity(i)
        finish()
    }
}