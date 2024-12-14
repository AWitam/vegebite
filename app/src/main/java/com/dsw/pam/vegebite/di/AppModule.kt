package com.dsw.pam.vegebite.di

import org.koin.dsl.module
val appModule = module {
    single<String>{
        "Hello Dependency Injection with Koin!"
    }
}