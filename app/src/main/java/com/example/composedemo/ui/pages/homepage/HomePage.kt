package com.example.composedemo.ui.pages.homepage

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.composedemo.R
import com.example.composedemo.repository.FakeRepository
import com.example.composedemo.repository.FakeRepositoryImpl
import com.example.composedemo.ui.theme.ComposeDemoTheme
import com.example.composedemo.ui.commons.AppBar

@Composable
fun HomePage(homePageViewModel: HomePageViewModel,
             navController: NavHostController,
             fakeRepository: FakeRepository
) {
    Scaffold(
        floatingActionButton = { Fabs(homePageViewModel) }
    ) {
        Content(homePageViewModel, navController, fakeRepository)
    }

}

@Composable
fun Content(pageViewModel: HomePageViewModel,
            navController: NavHostController, fakeRepository: FakeRepository
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            style = MaterialTheme.typography.h2,
            text = pageViewModel.counter.toString(),
            color = when {
                pageViewModel.counter < 0 -> Color.Red
                pageViewModel.counter > 0 -> Color.Green
                else -> MaterialTheme.colors.primary
            }
        )
        Text(text= fakeRepository.sayHello())
        Button(
            onClick={
                navController.navigate("details")
            }) {
            Text("go to details")
        }
    }
}

@Composable
fun Fabs(pageViewModel: HomePageViewModel) {
    Column {
        FloatingActionButton(onClick = { pageViewModel.increment() }) {
            Icon(
                painter = painterResource(id =R.drawable.ic_baseline_add_24),
                contentDescription = "Add")
        }
        FloatingActionButton(onClick = { pageViewModel.decrement() }) {
            Icon(
                painter = painterResource(id =R.drawable.ic_baseline_remove_24),
                contentDescription = "remove"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val homePageViewModel = HomePageViewModel()
    val navHostController = rememberNavController()
    val fakeRepository = FakeRepositoryImpl()
    ComposeDemoTheme {
        HomePage(homePageViewModel, navHostController, fakeRepository)
    }

}