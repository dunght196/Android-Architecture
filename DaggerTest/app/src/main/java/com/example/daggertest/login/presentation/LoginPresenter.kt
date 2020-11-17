package com.example.daggertest.login.presentation

import android.util.Log
import com.example.daggertest.lifecycle.CancelStrategy
import com.example.daggertest.network.ApiInterface
import com.example.daggertest.network.request.LoginBody
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

class LoginPresenter @Inject constructor(
    private val view: LoginView,
    private val apiInterface: ApiInterface
) {

    fun login(userNam: String, passWord: String) {
        apiInterface.login(LoginBody("dunght", "12345678"))
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                view.checkLogin(it.status)
            }
    }

}