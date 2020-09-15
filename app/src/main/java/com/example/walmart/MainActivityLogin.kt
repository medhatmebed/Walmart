package com.example.walmart

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main_login.*

class MainActivityLogin : AppCompatActivity() {

    var userList = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_login)

        //call action methods
        initializeUserModel()
        actionListenerLoginBtn()
        actionListenerCreateAccountBtn()
        actionListenerForgetPasswordTxt()
    }

    fun initializeUserModel(){
        userList.add(User("medhat","meebed","m@m.com","123"))
        userList.add(User("bleard","rexje","b@r.com","123"))
        userList.add(User("perry","luigi","p@l.com","123"))
        userList.add(User("ali","mohamed","a@m.com","123"))
        userList.add(User("omar","mahmoud","o@m.com","123"))
    }

    //Actions
    fun actionListenerLoginBtn() {
        val loginBtn = findViewById<Button>(R.id.signInBtn)
        loginBtn.setOnClickListener {
            val userName = emailEditTxt.text.toString()
            val password = passwordEditTxt.text.toString()
            for (user in userList) {
                if (user.email.equals(userName) && user.password.equals(password)) {
                    val intent = Intent(this,Registration::class.java)
                    intent.putExtra("userName",user.email)
                    startActivity(intent)
                }
            }
        }
    }

    fun actionListenerCreateAccountBtn() {
        val createAcctountBtn = findViewById<Button>(R.id.createAccountBtn)
        createAcctountBtn.setOnClickListener {
            val intent = Intent(this@MainActivityLogin,Registration::class.java)
            startActivityForResult(intent, 1)
        }
    }

    fun actionListenerForgetPasswordTxt() {
        val forgetPassword = findViewById<TextView>(R.id.forgotPasswordTxtView)
        var password = "your password is : "
        var email = ""
        forgetPassword.setOnClickListener {
            var email = emailEditTxt.text.toString()
            userList.forEach { user ->
                if (email.equals(user.email)) {
                    password += user.password
                    email = user.email
                }
            }

            composeEmail(email,password)

        }
    }

    //implicit intent for composing email
    fun composeEmail(address: String, subject: String) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:") // only email apps should handle this
            putExtra(Intent.EXTRA_EMAIL, address)
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    //receive the data from Registration Activity
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val user = data?.getSerializableExtra("newUser") as User
                userList.add(user)
                Toast.makeText(this, "Account created successfully", Toast.LENGTH_LONG).show()

            }
        }
    }

}
