package com.example.daggertest.home.di

import com.example.daggertest.dagger.scope.PerFragment
import com.example.daggertest.home.ui.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class HomeFragmentProvider {
    @ContributesAndroidInjector(modules = [HomeFragmentModule::class])
    @PerFragment
    abstract fun provideHomeFragment(): HomeFragment
}