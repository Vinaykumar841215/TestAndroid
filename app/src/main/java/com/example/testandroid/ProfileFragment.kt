package com.example.testandroid

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ProfileFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_profile, container, false)

        val localStorage = activity?.getSharedPreferences("user", Context.MODE_PRIVATE)

        val userName = localStorage?.getString("userName", "userName not found")
        val phone = localStorage?.getString("Phone", "userphone not found")
        val pass = localStorage?.getString("Password", "userpassword not found")

        val getNmae = view.findViewById<TextView>(R.id.userName1)
        val getphone = view.findViewById<TextView>(R.id.phone1)
        val getpass = view.findViewById<TextView>(R.id.pass1)



        getNmae.text = userName.toString()
        getphone.text = phone.toString()
        getpass.text = pass.toString()

        return view
    }

}