package com.example.daggertest.home.presentation

import com.example.daggertest.network.respons.MoviePopular

interface HomeView {

    fun getListMoviesPopular(items: MoviePopular)

}