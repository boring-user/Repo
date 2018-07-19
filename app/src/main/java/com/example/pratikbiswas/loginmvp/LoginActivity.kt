package com.example.pratikbiswas.loginmvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.pratikbiswas.loginmvp.Model.LoginPresenterImpl
import com.example.pratikbiswas.loginmvp.Presenter.LoginPresenter
import com.example.pratikbiswas.loginmvp.View.LoginView

class LoginActivity : AppCompatActivity(),View.OnClickListener,LoginView {



    lateinit var userName: EditText
    lateinit var password: EditText
    lateinit var loginBut: TextView
    lateinit var progressbar: ProgressBar
    var loginPresenter: LoginPresenter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userName = findViewById(R.id.usernameb)
        password = findViewById(R.id.passwordb)
        loginBut = findViewById(R.id.loginb)
        progressbar = findViewById(R.id.pBar)

        loginBut.setOnClickListener(this)
        loginPresenter = LoginPresenterImpl(this)

        onSetProgressVisibility(View.INVISIBLE)
    }

    override fun onClick(p0: View?) {
        onSetProgressVisibility(View.VISIBLE)
        loginBut.isEnabled
        val username: String = userName.text.toString()
        val password: String = password.text.toString()
        loginPresenter?.performLogin(username,password)

    }

    override fun loginValidations() {
        Toast.makeText(applicationContext,"Please enter valid credentials!",Toast.LENGTH_SHORT).show()
    }

    override fun onSuccess() {
        Toast.makeText(applicationContext,"Success!",Toast.LENGTH_SHORT).show()
        onSetProgressVisibility(View.INVISIBLE)

    }

    override fun onFailure() {
        Toast.makeText(applicationContext,"Failed!",Toast.LENGTH_SHORT).show()
        onSetProgressVisibility(View.INVISIBLE)
    }

    override fun onSetProgressVisibility(visibility: Int) {
        progressbar.visibility = visibility
    }
}
