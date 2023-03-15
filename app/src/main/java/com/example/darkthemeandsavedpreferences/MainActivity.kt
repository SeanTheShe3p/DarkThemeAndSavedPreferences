package com.example.darkthemeandsavedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Display.Mode
import android.widget.EditText
import android.widget.ImageView
import android.widget.Switch

class MainActivity : AppCompatActivity() {

    lateinit var name: EditText
    lateinit var number:EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val SP = getSharedPreferences("SharedPreferences", MODE_PRIVATE)
        val darkTheme = SP.getBoolean("dark",false)


        if (darkTheme){
            setTheme(androidx.appcompat.R.style.Theme_AppCompat_DayNight_DarkActionBar)
            val imgview = findViewById<ImageView>(R.id.imageView)
            imgview.setImageResource(R.drawable.ghost)
        }

        val switch1 = findViewById<Switch>(R.id.switch1)
        switch1.isChecked = darkTheme
        switch1.setOnCheckedChangeListener{
            view, isChecked -> toggleTheme(isChecked){

        }
        }


    }

    private fun toggleTheme(darkTheme: Boolean, function: () -> Unit) {
        val editor = getSharedPreferences("SharedPreferences", MODE_PRIVATE).edit()
        val toggle = getSharedPreferences("SharedPreferences", MODE_PRIVATE)
        val isCheckedDark = toggle.getBoolean("dark", false)
        if (!isCheckedDark) {
            editor.apply {
                putBoolean("dark", true)
                apply()
            }
            if (isCheckedDark){
                editor.apply {
                    putBoolean("dark", false)
                    apply()
                }
                val intent = intent
                finish()
                startActivity(intent)
            }
            val intent = intent
            finish()
            startActivity(intent)
        }
    }
    override fun onPause() {
        super.onPause()
        val SP = getSharedPreferences("SharedPreferences", MODE_PRIVATE)
        var myEdit = SP.edit()
        var key1 = findViewById<EditText>(R.id.edit1)
        var key2 = findViewById<EditText>(R.id.edit2)

        var edittextline1 = key1.getText().toString()
        var edittextline2 = key2.getText().toString()
        myEdit.putString("name", edittextline1)
        myEdit.putString("number", edittextline2)
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