package com.example.mvpproject.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mvpproject.R
import com.example.mvpproject.login.LoginActivity
import kotlin.math.log

class MainActivity : AppCompatActivity()  ,  MainContract.MainView {

    private lateinit var presenter: MainContract.MainPresenter

    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){
        bindViews()
        loginButton.setOnClickListener {
            presenter = MainPresenterImpl(this)
            presenter.handleLoginButton()
        }
    }

    override fun showLoginView() {
        val intent = Intent(this , LoginActivity::class.java)
        startActivity(intent)
    }

    private fun bindViews() {
        loginButton = findViewById(R.id.login_btn)
    }


}