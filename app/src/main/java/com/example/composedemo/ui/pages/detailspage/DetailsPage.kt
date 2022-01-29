package com.example.composedemo.ui.pages.detailspage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.navigation.HOME
import com.example.composedemo.ui.commons.AppBar
import com.example.composedemo.ui.theme.ComposeDemoTheme

@Composable
fun DetailsPage(
    navController: NavHostController,
    detailsPageViewModel: DetailsPageViewModel){

    Column(
        modifier=Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text=detailsPageViewModel.title)
        Button(
            onClick={ navController.navigate(HOME) }
        ) {
            Text(text="back to home")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DetailsPreview(){
    val navHostController = rememberNavController()
    val detailsPageViewModel = DetailsPageViewModel()
    ComposeDemoTheme {
        DetailsPage(navController = navHostController,
        detailsPageViewModel = detailsPageViewModel)
    }
}