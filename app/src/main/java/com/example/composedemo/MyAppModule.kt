package com.example.composedemo

import com.example.composedemo.repository.FakeRepository
import com.example.composedemo.repository.FakeRepositoryImpl
import com.example.composedemo.ui.pages.detailspage.DetailsPageViewModel
import com.example.composedemo.ui.pages.homepage.HomePageViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val myAppModule = module {

    //Caso interfaccia + classe impl
    single<FakeRepository> { FakeRepositoryImpl() }

    //Caso classe singola
    //single { Classe() }

    //Caso viewModel
    viewModel { HomePageViewModel() }
    viewModel { DetailsPageViewModel() }
}