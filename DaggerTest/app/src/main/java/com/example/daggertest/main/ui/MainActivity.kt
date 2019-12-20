package com.example.daggertest.main.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.daggertest.login.ui.LoginFragment
import com.example.daggertest.main.presentation.MainPresenter
import com.example.daggertest.main.presentation.MainView
import com.example.daggertest.R
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasAndroidInjector,
    MainView {

    @Inject
    lateinit var presenter: MainPresenter
    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate(savedInstanceState: Bundle?) {

        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(
                R.id.fragment_holder,
                LoginFragment()
            )
            .commit()

    }


    override fun androidInjector(): AndroidInjector<Any> {
        return fragmentDispatchingAndroidInjector
    }

    override fun test() {
    }

}
