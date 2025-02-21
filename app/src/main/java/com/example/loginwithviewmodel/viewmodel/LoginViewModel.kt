package com.example.loginwithviewmodel.viewmodel

import androidx.lifecycle.ViewModel
import com.example.loginwithviewmodel.repository.LoginRepo

//extend th ViewModel class to hold the data of UI

class LoginViewModel(private val repo: LoginRepo): ViewModel() {
        fun login(username:String, password:String):Boolean{
            return repo.authentication(username,password)
        }
}