package com.example.mvpproject.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.example.mvpproject.R
import com.example.mvpproject.login.data.UserCredentials

class LoginActivity : AppCompatActivity(), LoginContract.LoginView {

    private lateinit var txtUsername: EditText
    private lateinit var txtPassword: EditText
    private lateinit var btnSignIn: Button
    private lateinit var loginProgressBar: ProgressBar

    private lateinit var presenterImpl: LoginContract.LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        init()
    }

    private fun init() {
        bindViews()
        presenterImpl = LoginPresenterImpl(this)
        btnSignIn.setOnClickListener {
            val userCredentials =
                UserCredentials(txtUsername.text.toString(), txtPassword.text.toString())
            presenterImpl.handleLogin(userCredentials)
        }
    }

    private fun bindViews() {
        txtUsername = findViewById(R.id.txtUsername)
        txtPassword = findViewById(R.id.txtPassword)
        btnSignIn = findViewById(R.id.btnSignIn)
        loginProgressBar = findViewById(R.id.login_progressBar)
    }

    override fun onError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onSuccess() {
        Toast.makeText(this, " Login Succeed ", Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        loginProgressBar.visibility = View.VISIBLE
        btnSignIn.visibility = View.GONE
    }

    override fun hideLoading() {
        loginProgressBar.visibility = View.GONE
        btnSignIn.visibility = View.VISIBLE
    }

}