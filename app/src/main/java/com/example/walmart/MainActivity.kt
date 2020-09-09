package com.example.walmart

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var userList = ArrayList<User>()
        userList.add(User("medhat","meebed","m@m.com","123"))
        userList.add(User("bleard","rexje","b@r.com","123"))
        userList.add(User("perry","luigi","p@l.com","123"))
        userList.add(User("ali","mohamed","a@m.com","123"))
        userList.add(User("omar","mahmoud","o@m.com","123"))
        
      
        val btn = findViewById<Button>(R.id.signInBtn)
        btn.setOnClickListener { 
            val userName = emailEditTxt.text.toString()
            val password = passwordEditTxt.text.toString()
            for (user in userList) {
                if (user.email.equals(userName) && user.password.equals(password)) {
                    Toast.makeText(this, "login verified", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,Shopping::class.java)
                    intent.putExtra("userName",user.email)
                    startActivity(intent)
                }
            }
        }
        
    }
}