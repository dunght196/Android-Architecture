package com.example.daggertest.home.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.daggertest.R
import com.example.daggertest.home.presentation.HomePresenter
import com.example.daggertest.home.presentation.HomeView
import com.example.daggertest.network.respons.MoviePopular
import com.example.daggertest.util.extensions.ui
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment(), HomeView {
    @Inject
    lateinit var presenter: HomePresenter

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getListMoviePopular()
    }

    override fun getListMoviesPopular(items: String?) {
        ui {
            tv.text = items
        }
    }
}