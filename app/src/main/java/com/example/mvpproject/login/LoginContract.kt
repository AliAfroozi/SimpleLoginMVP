package com.example.mvpproject.login

import android.telephony.SmsMessage
import com.example.mvpproject.login.data.UserCredentials

interface LoginContract {

    interface LoginView {

        fun onError(message: String)

        fun onSuccess()

        fun showLoading()

        fun hideLoading()
    }

    interface LoginPresenter {

        fun handleLogin(userCredentials: UserCredentials)

        fun handleError(message: String)

        fun handleSuccess()
    }
}