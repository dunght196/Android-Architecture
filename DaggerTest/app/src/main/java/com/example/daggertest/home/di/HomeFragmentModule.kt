package com.example.daggertest.home.di

import com.example.daggertest.dagger.scope.PerFragment
import com.example.daggertest.home.presentation.HomeView
import com.example.daggertest.home.ui.HomeFragment
import dagger.Module
import dagger.Provides

@Module
class HomeFragmentModule {
    @Provides
    @PerFragment
    fun provideHomeView(frag: HomeFragment): HomeView = frag
}