package com.lukieoo.dogapimvvm.di

import android.app.Application
import com.lukieoo.dogapimvvm.MyApplication
import com.lukieoo.dogapimvvm.utils.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        RepositoryModule::class,
        RetrofitModule::class,
        RoomModule::class,
        ViewModelModule::class,
        ComponentModule::class
    ]
)


interface AppComponent :
    AndroidInjector<MyApplication> {
    fun inject(application: Application)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

}