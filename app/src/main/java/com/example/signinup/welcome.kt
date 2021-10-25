package com.example.signinup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class welcome : AppCompatActivity() {
    lateinit var tvw: TextView
    lateinit var tvd: TextView
    lateinit var bout: Button
    lateinit var mem:Member
    lateinit var dbh:Dbhelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        tvw = findViewById(R.id.tvwelcome)
        tvd = findViewById(R.id.tvlocname)
        bout = findViewById(R.id.butout)
        bout.setOnClickListener {
            intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
        dbh=Dbhelper(this)
        mem=dbh.getmem(intent.getStringExtra("key")!!)
        tvw.text="welcome ${mem.name}"
        tvd.text="name: ${mem.name}\nLocation: ${mem.location}"

    }
}