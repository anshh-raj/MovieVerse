package com.example.movieverse.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.movieverse.model.Movie
import com.example.movieverse.model.getMovies
import com.example.movieverse.navigation.MovieScreens
import com.example.movieverse.widgets.MovieRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text("Movies")
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                ),

                )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding)
        ) {
            MainContent(navController)
        }
    }
}

@Composable
fun MainContent(navController: NavController ,
                movieList: List<Movie> = getMovies()
){
    Column(
        modifier = Modifier
            .padding(12.dp)
    ) {
        LazyColumn {
            items(
                movieList
            ){
                MovieRow(it){ movieId->
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movieId")
                }
            }
        }
    }
}

