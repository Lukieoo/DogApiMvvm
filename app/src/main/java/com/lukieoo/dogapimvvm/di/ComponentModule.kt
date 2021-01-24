package com.lukieoo.dogapimvvm.di

import android.app.Application
import com.lukieoo.dogapimvvm.ui.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.DaggerApplication


@Module
abstract class  ComponentModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}