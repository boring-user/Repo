package com.example.pratikbiswas.loginmvp.Model

import android.os.Handler
import android.os.Looper
import com.example.pratikbiswas.loginmvp.Presenter.LoginPresenter
import com.example.pratikbiswas.loginmvp.View.LoginView

class LoginPresenterImpl(internal var loginView: LoginView) : LoginPresenter {

    var handler: Handler

    init {
        handler = Handler(Looper.getMainLooper())
    }

    override fun performLogin(userName: String, password: String) {
        if (userName.isEmpty() || password.isEmpty()) {
            loginView.loginValidations()
        } else {
            if (userName == "hi" && password == "hi") {
                handler.postDelayed({loginView.onSuccess()},5000)
            } else {
                handler.postDelayed({loginView.onFailure()},5000)
            }
        }
    }
}
