package com.example.testandroid

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class HomeActivity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home2)
//
//
//        val localStorage = getSharedPreferences("user",Context.MODE_PRIVATE)
//
//        val getName = localStorage.getString("userName","name Not Found")
//        val getPhone = localStorage.getString("userPhone","phone Not Found")
//        val getPassword = localStorage.getString("userPassword","password Not Found")
//
//
//        val name1= findViewById<TextView>(R.id.name1)
//        val phone1 = findViewById<TextView>(R.id.phone1)
//        val pass1 = findViewById<TextView>(R.id.pass1)
//
//        name1.text = getName.toString()
//        phone1.text = getPhone.toString()
//        pass1.text =getPassword.toString()
//
//
//        Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()
//        Toast.makeText(this, "$getName", Toast.LENGTH_SHORT).show()
//        Toast.makeText(this, "$getPhone", Toast.LENGTH_SHORT).show()
//        Toast.makeText(this, "$getPassword", Toast.LENGTH_SHORT).show()

        changeFrament(HomeFragment())
        val drawerLayout = findViewById<DrawerLayout>(R.id.dragLayout)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {


                R.id.home -> {
                    changeFrament(HomeFragment())
                    Toast.makeText(this, "Home app", Toast.LENGTH_SHORT).show()
                }

                R.id.card -> {
                    changeFrament(CardFragment())
                    Toast.makeText(this, "Card", Toast.LENGTH_SHORT).show()
                }


                R.id.profile -> {
                    changeFrament(ProfileFragment())
                    Toast.makeText(this, "profile", Toast.LENGTH_SHORT).show()
                }
            }
            drawerLayout.close()
            true
        }

        toolbar.setNavigationOnClickListener {
            drawerLayout.open()
        }
        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottomNavigation)
        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {

                R.id.card -> {
                    changeFrament(CardFragment())
                }

                R.id.home -> {
                    changeFrament(HomeFragment())
                }


                R.id.profile -> {
                    changeFrament(ProfileFragment())

                }
            }

            true

        }
    }

    fun changeFrament(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, fragment).commit()
    }

}

