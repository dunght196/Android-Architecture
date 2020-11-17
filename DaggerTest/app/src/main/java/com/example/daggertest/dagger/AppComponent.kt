package com.example.daggertest.dagger

import android.app.Application
import com.example.daggertest.app.MyApplication
import com.example.daggertest.dagger.module.ActivityBuilder
import com.example.daggertest.dagger.module.AndroidWorkerInjectionModule
import com.example.daggertest.dagger.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityBuilder::class,
        AndroidWorkerInjectionModule::class
    ]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
//        fun create(@BindsInstance context: Context): AppComponent
        fun application(application: Application): Builder

        fun build(): AppComponent

    }

    fun inject(application: MyApplication)

}