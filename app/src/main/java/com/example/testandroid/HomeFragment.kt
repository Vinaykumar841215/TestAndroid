package com.example.testandroid

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class HomeFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_home, container, false)

        val localStorage = activity?.getSharedPreferences("user", Context.MODE_PRIVATE)

        val logout = view.findViewById<Button>(R.id.login)
        val openNew = view.findViewById<Button>(R.id.openNew)
        openNew.setOnClickListener {
            startActivity(Intent(requireContext(),MenuActivity::class.java))
        }

        val editprfe= localStorage?.edit()

        logout.setOnClickListener {
            localStorage?.edit()?.clear()?.apply()
            val intet= Intent(requireContext(),MainActivity::class.java)
            startActivity(intet)

        }


        return view
    }
}