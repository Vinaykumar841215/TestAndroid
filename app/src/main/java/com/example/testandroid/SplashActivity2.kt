package com.example.testandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash2)
        val localStorage = getSharedPreferences("user", Context.MODE_PRIVATE)
        val status=localStorage.getBoolean("loginStatus",false)
        Handler().postDelayed(Runnable {
            if (status!=true){
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
            }
            else {
                val intent = Intent(this, HomeActivity2::class.java)
                startActivity(intent)
            }
        },2000)
    }
}