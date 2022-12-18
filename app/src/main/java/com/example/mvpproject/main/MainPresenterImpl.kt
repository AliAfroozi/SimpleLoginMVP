package com.example.mvpproject.main

class MainPresenterImpl(private val view: MainContract.MainView) : MainContract.MainPresenter {

    override fun handleLoginButton() {
        view.showLoginView()

        
    }
}