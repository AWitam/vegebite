package com.dsw.pam.vegebite.di


import org.koin.core.module.dsl.viewModel
import com.dsw.pam.vegebite.ui.screens.RestaurantViewModel

import org.koin.dsl.module

val appModule = module {
    viewModel {
        RestaurantViewModel()
    }
}