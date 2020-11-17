package com.example.daggertest.login.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.daggertest.login.presentation.LoginPresenter
import com.example.daggertest.login.presentation.LoginView
import com.example.daggertest.R
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment : Fragment(), LoginView {
    @Inject
    lateinit var presenter: LoginPresenter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_login.setOnClickListener {
            presenter.login("dunght", "12345678")
        }

    }

    override fun checkLogin(status: String?) {
        if(status == "success") {
            Log.d("dz196", "Status: $status")
        }
    }


}