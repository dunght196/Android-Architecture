package com.example.daggertest.network.response

data class MoviePopularResponse (
    val total_results: Int?,
    val total_pages: Int?,
    val results: MutableList<MoviePopularInfo>?
)
