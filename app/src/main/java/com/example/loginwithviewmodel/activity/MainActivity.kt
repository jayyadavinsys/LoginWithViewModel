package com.example.loginwithviewmodel.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.loginwithviewmodel.R
import com.example.loginwithviewmodel.viewmodel.LoginViewModel
import com.example.loginwithviewmodel.factory.LoginViewModelFactory
import com.example.loginwithviewmodel.repository.LoginRepo


class MainActivity : AppCompatActivity() {


    //create the variable to get the views id from layout at runtime

    private  lateinit var usernameId: EditText
    private lateinit var passwordId: EditText
    private lateinit var btnId: Button

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btnId = findViewById(R.id.btn)
        usernameId = findViewById(R.id.textEdit1)
        passwordId = findViewById(R.id.textEdit2)

        //get the instance of viewModels

        val factory= LoginViewModelFactory(LoginRepo())
        loginViewModel= ViewModelProvider(this, factory)[LoginViewModel::class.java]


        //when click on the login button
        btnId.setOnClickListener {
            val user = usernameId.editableText.toString()
            val password = passwordId.editableText.toString()

            //calling the function login which persent in LoginViewModel

            val isLoginSuccessful = loginViewModel.login(user, password)

            if (isLoginSuccessful) {
                Toast.makeText(this, "LoginSuccessfully", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Invalid UserName or Password", Toast.LENGTH_LONG).show()
            }

        }
    }
}