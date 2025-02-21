package com.example.loginwithviewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.loginwithviewmodel.repository.LoginRepo
import com.example.loginwithviewmodel.viewmodel.LoginViewModel

// This class is used to create instances of LoginViewModel, passing dependencies to it.

class LoginViewModelFactory(private val repo: LoginRepo) :ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(repo) as T
    }


}