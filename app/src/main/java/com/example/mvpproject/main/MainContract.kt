package com.example.mvpproject.main

interface MainContract {

    interface MainView {
        fun showLoginView()
    }

    interface MainPresenter {
        fun handleLoginButton()
    }
}