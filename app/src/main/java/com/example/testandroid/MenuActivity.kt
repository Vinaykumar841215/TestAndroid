package com.example.testandroid

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ListView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast

class MenuActivity<Menu> : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    lateinit var homelayout:LinearLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        homelayout = findViewById(R.id.homeayout)
        val text = findViewById<TextView>(R.id.hello)
        val button = findViewById<Button>(R.id.button)
        // popup menu

        button.setOnClickListener {
            val popupmenu = PopupMenu(this, text)
            popupmenu.menuInflater.inflate(R.menu.menu, popupmenu.menu)
            popupmenu.show()

            popupmenu.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.home -> {
                        Toast.makeText(this, "Popup_Menu_Home", Toast.LENGTH_SHORT).show()
                        homelayout.setBackgroundColor(Color.parseColor("#ff0000"))
                    }


                    R.id.card -> {
                        Toast.makeText(this, "Popup_Menu_Home", Toast.LENGTH_SHORT).show()
                        homelayout.setBackgroundColor(Color.parseColor("#83F13F"))
                    }

                    R.id.Profile -> {
                        Toast.makeText(this, "Popup_Menu_Setting", Toast.LENGTH_SHORT).show()
                        homelayout.setBackgroundColor(Color.parseColor("#3F57F1"))
                    }
                }
                true
            }

        }

        val student = arrayOf("Vinay kumar", "Ajit kumar", "Princ kumar", "Ravi kumar")
        var listV = findViewById<ListView>(R.id.listse)
        val Studentadapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, student)
        listV.adapter = Studentadapter
        registerForContextMenu(listV)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menu!!.setHeaderTitle("Select Below Item")
        menu?.add(0,v!!.id,0,"Vinay")
        menu?.add(0,v!!.id,0,"Ajit")
        menu?.add(0,v!!.id,0,"Princ")
        menu?.add(0,v!!.id,0,"Ravi kumar")
    }
    override fun onContextItemSelected(item: MenuItem): Boolean {

        when (item.title) {
       R.id.home.toString() ->{
           Toast.makeText(this, "bsagdjah", Toast.LENGTH_SHORT).show()
           homelayout.setBackgroundColor(Color.parseColor("#4DE1BC"))

       }

             R.id.card.toString() ->{
                 Toast.makeText(this, "List_menu_card", Toast.LENGTH_SHORT).show()
                 homelayout.setBackgroundColor(Color.parseColor("#EF5BGF"))
             }

            "Pr" -> {
                Toast.makeText(this, "List_Menu_Setting", Toast.LENGTH_SHORT).show()
                homelayout.setBackgroundColor(Color.parseColor("#EF5BFF"))
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.home -> {
                Toast.makeText(this, "Context_Menu_Home", Toast.LENGTH_SHORT).show()
                homelayout.setBackgroundColor(Color.parseColor("#FF5BB5"))
            }

            R.id.Cast -> {
                Toast.makeText(this, "Context_Menu_Cast", Toast.LENGTH_SHORT).show()
                homelayout.setBackgroundColor(Color.parseColor("#5BFFC6"))
            }

            R.id.Profile -> {
                Toast.makeText(this, "Context_Menu_Setting", Toast.LENGTH_SHORT).show()
                homelayout.setBackgroundColor(Color.parseColor("#FAA324"))
            }
        }
        return false
    }



}



private fun PopupMenu.setHeaderTitle(s: String) {
    TODO("Not yet implemented")
}
