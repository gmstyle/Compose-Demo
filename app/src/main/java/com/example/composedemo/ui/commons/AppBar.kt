package com.example.composedemo.ui.commons

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable

const val APP_TITLE = "Compose Counter Demo"

@Composable
fun AppBar(){
    TopAppBar {
        Text(text = APP_TITLE)
    }
}