package com.example.daggertest.home.presentation

import com.example.daggertest.lifecycle.CancelStrategy
import com.example.daggertest.network.ApiInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class HomePresenter @Inject constructor(
    private val view: HomeView,
    private val apiInterface: ApiInterface,
    private val strategy: CancelStrategy
) {

    fun getListMoviePopular(page: Int?) = runBlocking {
        launch(Dispatchers.IO + strategy.jobs) {
            apiInterface.getMoviePopular(page).let { movies ->
                movies.let {
                    view.getListMoviesPopular(it.results)
                }
            }
        }
    }
}