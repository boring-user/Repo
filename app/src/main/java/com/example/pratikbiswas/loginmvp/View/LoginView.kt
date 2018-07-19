package com.example.pratikbiswas.loginmvp.View

interface LoginView {
    fun loginValidations()
    fun onSuccess()
    fun onFailure()
    fun onSetProgressVisibility(visibility: Int)
}
