package com.example.loginwithviewmodel.repository

class LoginRepo  {
    //authentication method confirm the username and password
    fun authentication(username: String, password: String): Boolean {
        return username=="admin" && password=="12345678"
    }
}