package com.example.daggertest.home.presentation

import com.example.daggertest.network.response.MoviePopularInfo

interface HomeView {

    fun getListMoviesPopular(items: MutableList<MoviePopularInfo>?)

}