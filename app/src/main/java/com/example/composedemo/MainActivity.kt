package com.example.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.navigation.DETAILS
import com.example.composedemo.navigation.HOME
import com.example.composedemo.repository.FakeRepository
import com.example.composedemo.ui.commons.AppBar
import com.example.composedemo.ui.pages.detailspage.DetailsPage
import com.example.composedemo.ui.pages.detailspage.DetailsPageViewModel
import com.example.composedemo.ui.pages.homepage.HomePage
import com.example.composedemo.ui.pages.homepage.HomePageViewModel
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {

    private val homePageViewModel: HomePageViewModel by viewModel()
    private val detailsPageViewModel: DetailsPageViewModel by viewModel()
    private val fakeRepository: FakeRepository by inject()
    private lateinit var composeDemoApplication: ComposeDemoApplication
    lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //1 - NAVCONTROLLER
            navHostController = rememberNavController()

            //2 - NAVIGATION COMPONENT
            Scaffold(
                topBar = { AppBar() },
            ) {
                // Messo nello scaffold inserisce le view dentro lo scaffold.
                // Utile per mantenere un contenitore unico per le view
                NavigationComponent()
            }


        }
        composeDemoApplication = ComposeDemoApplication()

    }

    @Composable
    fun NavigationComponent(){
        NavHost(
            navController = navHostController,
            startDestination = HOME
        ){
            composable(HOME){
                HomePage(
                    homePageViewModel = homePageViewModel,
                    navController = navHostController,
                    fakeRepository = fakeRepository
                )
            }
            composable(DETAILS){
                DetailsPage(
                    navController = navHostController,
                    detailsPageViewModel = detailsPageViewModel
                )
            }
        }
    }

}
