package com.example.composedemo.ui.pages.homepage

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomePageViewModel : ViewModel() {
    var counter: Int by mutableStateOf(0)

    fun increment(){
        counter++
    }

    fun decrement(){
        counter--
    }
}