package com.example.daggertest.main.presentation

import android.util.Log
import com.example.daggertest.network.ApiInterface
import com.example.daggertest.network.request.LoginBody
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val apiInterface: ApiInterface,
    private val view: MainView
) {

}