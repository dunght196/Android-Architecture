package com.example.daggertest.dagger.module

import com.example.daggertest.login.di.LoginFragmentProvider
import com.example.daggertest.main.ui.MainActivity
import com.example.daggertest.main.di.MainModule
import com.example.daggertest.dagger.scope.PerActivity
import com.example.daggertest.home.di.HomeFragmentProvider
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @PerActivity
    @ContributesAndroidInjector(
        modules = [
            MainModule::class,
            LoginFragmentProvider::class,
            HomeFragmentProvider::class
        ]
    )
    abstract fun bindMainActivity(): MainActivity

}