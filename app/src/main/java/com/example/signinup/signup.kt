package com.example.signinup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class signup : AppCompatActivity() {
    lateinit var edfirst: EditText
    lateinit var edmobem:EditText
    lateinit var edpass:EditText
    lateinit var edloc:EditText
    lateinit var butin: Button
    lateinit var tvb: TextView
    lateinit var dbh:Dbhelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        init()
        tvb.setOnClickListener {
            intent= Intent(this,signin::class.java)
            startActivity(intent)
        }
        butin.setOnClickListener {
            register()
        }
    }
    fun init(){
        edfirst=findViewById(R.id.edfirst)
        edmobem=findViewById(R.id.edmobem)
        edpass=findViewById(R.id.edpassword)
        edloc=findViewById(R.id.edloc)
        butin=findViewById(R.id.signup)
        tvb=findViewById(R.id.tvsignin)
        dbh=Dbhelper(this)
    }
    fun register(){
        if(edfirst.text.isNotEmpty()&&edmobem.text.isNotEmpty()&&edpass.text.isNotEmpty()&&edloc.text.isNotEmpty()){
            var temp =dbh.getmem(edmobem.text.toString())
            if(temp.name.isEmpty()){
                dbh.addmem(edfirst.text.toString(),edmobem.text.toString(),edloc.text.toString(),edpass.text.toString())
                Toast.makeText(this,"registered successfully",Toast.LENGTH_SHORT).show()
                intent=Intent(this,welcome::class.java)
                intent.putExtra("key",edmobem.text.toString())
                startActivity(intent)
            }else Toast.makeText(this,"user already registred",Toast.LENGTH_SHORT).show()
        }else Toast.makeText(this,"field can`t be empty",Toast.LENGTH_SHORT).show()
    }
}