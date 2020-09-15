package com.example.walmart

import java.io.Serializable

class User(firstName:String, lastName: String, email: String,password:String): Serializable {
    var email: String = email
    var firstName = firstName
    var lastName = lastName
    var password = password

}