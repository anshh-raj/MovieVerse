package com.example.movieverse.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movieverse.screens.details.DetailsScreen
import com.example.movieverse.screens.home.HomeScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = MovieScreens.HomeScreen.name){
        composable(MovieScreens.HomeScreen.name){
            HomeScreen(navController)
        }
        composable(MovieScreens.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie"){type = NavType.StringType})
        ){ backStackEntry ->
            DetailsScreen(navController, backStackEntry.arguments?.getString("movie"))
        }
    }
}