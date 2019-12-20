package com.example.daggertest.login.di

import com.example.daggertest.login.presentation.LoginView
import com.example.daggertest.dagger.scope.PerFragment
import com.example.daggertest.login.ui.LoginFragment
import dagger.Module
import dagger.Provides

@Module
class LoginFragmentModule {
    @Provides
    @PerFragment
    fun provideLoginView(frag: LoginFragment): LoginView = frag
}