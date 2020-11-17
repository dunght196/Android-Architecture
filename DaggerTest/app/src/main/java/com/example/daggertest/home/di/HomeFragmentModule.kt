package com.example.daggertest.home.di

import com.example.daggertest.dagger.scope.PerFragment
import com.example.daggertest.home.presentation.HomeView
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {
    @Provides
    @PerFragment
    fun provideHomeView(frag: HomeView): HomeView = frag
}