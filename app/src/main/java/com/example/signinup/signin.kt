package com.example.signinup

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class signin : AppCompatActivity() {
    lateinit var edin: EditText
    lateinit var edpass:EditText
    lateinit var login: Button
    lateinit var new:Button
    lateinit var dbh:Dbhelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)
        init()
        new.setOnClickListener{
            intent= Intent(this,signup::class.java)
            startActivity(intent)
        }
        login.setOnClickListener{
            if(edin.text.isNotEmpty()&&edpass.text.isNotEmpty()) {
                var temp = dbh.getmem(edin.text.toString())
                if (temp.password.isNotEmpty()){
                    if (temp.password.toInt() == edpass.text.toString().hashCode()) {
                        intent = Intent(this, welcome::class.java)
                        intent.putExtra("key", temp.contact)
                        startActivity(intent)
                    } else Toast.makeText(this, "Name or password is incorrect", Toast.LENGTH_SHORT).show()
                }else Toast.makeText(this,"user doesn`t exist",Toast.LENGTH_SHORT).show()
            }
        }
    }
    fun init(){
        edin=findViewById(R.id.edin)
        edpass=findViewById(R.id.edpass)
        login=findViewById(R.id.butinin)
        new=findViewById(R.id.butnew)
        dbh=Dbhelper(this)
    }
}