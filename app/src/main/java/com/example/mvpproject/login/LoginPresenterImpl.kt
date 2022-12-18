package com.example.mvpproject.login

import com.example.mvpproject.login.data.LoginInteractor
import com.example.mvpproject.login.data.UserCredentials

class LoginPresenterImpl(private val view: LoginContract.LoginView) : LoginContract.LoginPresenter {

    private var loginInteractor = LoginInteractor(this)

    override fun handleLogin(userCredentials: UserCredentials) {
        view.showLoading()
        loginInteractor.checkLogin(userCredentials)
    }

    override fun handleError(message: String) {
        view.hideLoading()
        view.onError(message)
    }

    override fun handleSuccess() {
        view.hideLoading()
        view.onSuccess()
    }
}