package com.example.daggertest.network

import com.example.daggertest.network.request.LoginBody
import com.example.daggertest.network.response.MoviePopularResponse
import com.example.daggertest.network.response.LoginResponse
import io.reactivex.Observable
import retrofit2.http.*

interface ApiInterface {

    @POST("api/v1/login")
    fun login(
        @Body body: LoginBody
    ): Observable<LoginResponse>

    @GET("3/movie/popular")
    suspend fun getMoviePopular(@Query("page") page: Int?): MoviePopularResponse

}