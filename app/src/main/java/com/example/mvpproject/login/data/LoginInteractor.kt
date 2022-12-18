package com.example.mvpproject.login.data

import com.example.mvpproject.login.LoginContract

class LoginInteractor(private val presenter: LoginContract.LoginPresenter) {

    fun checkLogin(userCredentials: UserCredentials) {

        if (hasError(userCredentials)) {
            return
        }
        presenter.handleSuccess()
    }

    private fun hasError(userCredentials: UserCredentials): Boolean {

        if (userCredentials.username.isEmpty() || userCredentials.password.isEmpty()) {
            presenter.handleError(" Invalid value of username or password ")
            return true
        }

        // fixme : load user data from database or api by username and password instead of Mock data
        if (userCredentials.username != "admin" || userCredentials.password != "1234"){
            presenter.handleError(" Incorrect username of password ")
            return true
        }
            return false
    }
}