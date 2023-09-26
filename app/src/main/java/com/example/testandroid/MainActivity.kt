package com.example.testandroid

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userName= findViewById<EditText>(R.id.userName)
        val phone = findViewById<EditText>(R.id.phone)
        val password = findViewById<EditText>(R.id.pass)
        val login = findViewById<Button>(R.id.login)

        val localStorage = getSharedPreferences("user",Context.MODE_PRIVATE)
        login.setOnClickListener {

            val edipref = localStorage.edit()
            edipref.putBoolean("loginStatus",true)
            edipref.putString("userName",""+userName.text.toString())
            edipref.putString("Phone",""+phone.text.toString())
            edipref.putString("Password",""+password.text.toString()).apply()

            val intent = Intent(this,HomeActivity2::class.java)
            startActivity(intent)
        }


    }
}