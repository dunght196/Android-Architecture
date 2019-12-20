package com.example.daggertest.main.di

import com.example.daggertest.dagger.scope.PerActivity
import com.example.daggertest.main.presentation.MainView
import com.example.daggertest.main.ui.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    @PerActivity
    fun appMainView(activity: MainActivity): MainView {
        return activity
    }
}