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
import javax.inject.Inject

class HomeFragment : Fragment(), HomeView {

    @Inject
    lateinit var presenter: HomePresenter

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.getListMoviePopular()

    }

    override fun getListMoviesPopular(items: MoviePopular) {
        ui {
            Toast.makeText(context, items.total_results.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}