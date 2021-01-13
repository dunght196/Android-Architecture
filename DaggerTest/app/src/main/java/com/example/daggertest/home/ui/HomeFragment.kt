package com.example.daggertest.home.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.daggertest.R
import com.example.daggertest.home.presentation.HomePresenter
import com.example.daggertest.home.presentation.HomeView
import com.example.daggertest.network.response.MoviePopularInfo
import com.example.daggertest.util.extensions.ui
import dagger.android.support.AndroidSupportInjection
import kotlinx.android.synthetic.main.fragment_home.*
import javax.inject.Inject

class HomeFragment : Fragment(), HomeView {
    @Inject
    lateinit var presenter: HomePresenter

    private var adapterMovie: MoviePopularAdapter? = null
    private var page = 1


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
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
        initView()
        presenter.getListMoviePopular(page)
    }

    private fun initView() {
        adapterMovie = MoviePopularAdapter()
        rv_movies.adapter = adapterMovie
        rv_movies.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
    }

    override fun getListMoviesPopular(items: MutableList<MoviePopularInfo>?) {
        ui {
            items?.let {
                if (page == 1) {
                    adapterMovie?.appendData(items)
                }
            }
        }
    }
}