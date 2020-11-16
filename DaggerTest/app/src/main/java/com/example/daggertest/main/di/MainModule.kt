package com.example.daggertest.main.di

import androidx.lifecycle.LifecycleOwner
import com.example.daggertest.dagger.scope.PerActivity
import com.example.daggertest.lifecycle.CancelStrategy
import com.example.daggertest.main.presentation.MainView
import com.example.daggertest.main.ui.MainActivity
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.Job

@Module
class MainModule {

    @Provides
    @PerActivity
    fun appMainView(activity: MainActivity): MainView {
        return activity
    }

    @Provides
    @PerActivity
    fun provideJob(): Job = Job()

    @Provides
    fun provideLifecycleOwner(activity: MainActivity): LifecycleOwner = activity

    @Provides
    fun provideCancelStrategy(owner: LifecycleOwner, jobs: Job): CancelStrategy =
        CancelStrategy(owner, jobs)
}