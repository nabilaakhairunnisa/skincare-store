package com.nabila.skincarestore.di

import com.nabila.skincarestore.data.Repository

object Injection {
    fun provideRepository(): Repository {
        return Repository.getInstance()
    }
}