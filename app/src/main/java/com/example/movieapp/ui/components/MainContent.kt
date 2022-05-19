package com.example.movieapp.ui.components

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.movieapp.network.model.Search
import com.example.movieapp.ui.Screen

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainContent(viewModel: MainViewModel = hiltViewModel(), navController: NavController) {
    val query: MutableState<String> = remember { mutableStateOf("") }
    val result = viewModel.list.value
    Surface(modifier = Modifier.fillMaxSize()) {

        Column(modifier = Modifier.padding(10.dp)) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
            )
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Movie Search",
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
            )

            OutlinedTextField(
                value = query.value, onValueChange = {
                    query.value = it
                    viewModel.getImageList(query.value)

                }, enabled = true,
                singleLine = true,
                leadingIcon = {
                    Icon(imageVector = Icons.Default.Search, contentDescription = null)
                },
                label = { Text(text = "Search here...") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp)
            )


            if (result.isLoading) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }

            if (result.error.isNotBlank()) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    Text(
                        modifier = Modifier.align(Alignment.Center),
                        text = viewModel.list.value.error
                    )
                }
            }

            if (result.data.isNotEmpty()) {
                LazyVerticalGrid(cells = GridCells.Fixed(3)) {
                    Log.d("TAG", "MainContent: Your Token")
                    viewModel.list.value.data.let {
                        items(it) {
                            MainContentItem(it, navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MainContentItem(search: Search, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clickable {
                navController.navigate(
                    Screen.DetailContent.withArgs(
                        search.Title,
                        search.imdbID,
                        search.Type,
                        search.Year,
                        search.Poster
                    )
                )
            },
        elevation = 15.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(), content = {
                Image(
                    painter = rememberImagePainter(data = search.Poster),
                    contentScale = ContentScale.Crop,
                    contentDescription = search.Title,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                )
                Text(
                    text = search.Title, color = Color.Black,
                    modifier = Modifier
                        .height(20.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center,

                    )
            }
        )
    }
}