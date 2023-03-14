package com.example.darkthemeandsavedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var number:EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onPause() {
        super.onPause()
        val SP = getSharedPreferences("SharedPreferences", MODE_PRIVATE)
        var myEdit = SP.edit()
        var key1 = findViewById<EditText>(R.id.edit1).toString()
        var key2 = findViewById<EditText>(R.id.edit2).toString()
        myEdit.putString("name", key1)
        myEdit.putString("number", key2)
        myEdit.apply()
    }

    override fun onResume() {
        super.onResume()
        val SP = getSharedPreferences("SharedPreferences", MODE_PRIVATE)

        var name = SP.getString("name","")
        var number = SP.getString("number","")

        var nameView = findViewById<EditText>(R.id.edit1)
        var numView = findViewById<EditText>(R.id.edit2)

        nameView.setText(name)
        numView.setText(number)
    }
}