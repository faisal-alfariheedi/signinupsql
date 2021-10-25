package com.example.signinup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var inin: Button
    lateinit var up:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inin = findViewById(R.id.butin)
        up = findViewById(R.id.butup)
        inin.setOnClickListener {
            intent= Intent(this,signin::class.java)
            startActivity(intent)
        }
        up.setOnClickListener {
            intent=Intent(this,signup::class.java)
            startActivity(intent)

        }
    }
}