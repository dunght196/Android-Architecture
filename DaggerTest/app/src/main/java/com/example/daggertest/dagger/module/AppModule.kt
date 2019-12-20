package com.example.daggertest.dagger.module

import com.example.daggertest.network.ApiInterface
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun apiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Provides
    @Singleton
    fun retrofitClient(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://im.rikkei.org")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(1, TimeUnit.MINUTES)
                    .writeTimeout(1, TimeUnit.MINUTES)
                    .readTimeout(1, TimeUnit.MINUTES)
                    .addInterceptor { chain ->
                       /* if (!Prefs.getBoolean("LOGIN", false)) {
                            chain.proceed(chain.request().newBuilder().addHeader("Content-Type", "application/json").build())
                        } else {
                            chain.proceed(chain.request().newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .addHeader("X-Auth-Token", PrefHelper.getUserToken())
                                .addHeader("X-User-Id", PrefHelper.getUserID()).build())
                        }*/
                        chain.proceed(chain.request().newBuilder().addHeader("Content-Type", "application/json").build())
                    }
                    .addInterceptor(okhttp3.logging.HttpLoggingInterceptor().setLevel(okhttp3.logging.HttpLoggingInterceptor.Level.BODY))
                    .build())
            .build()
    }

}