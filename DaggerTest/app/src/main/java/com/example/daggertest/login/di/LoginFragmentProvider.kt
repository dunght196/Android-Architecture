package com.example.daggertest.login.di

import com.example.daggertest.dagger.scope.PerFragment
import com.example.daggertest.login.ui.LoginFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginFragmentProvider {
    @ContributesAndroidInjector(modules = [LoginFragmentModule::class])
    @PerFragment
    abstract fun provideLoginFragment(): LoginFragment
}