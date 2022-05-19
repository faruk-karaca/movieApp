package com.example.movieapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

@Composable

fun DetailContent(
    title: String? = "",
    imdbId: String? = "",
    type: String? = "",
    year: String? = "",
    poster: String? = ""
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(20.dp),

        ) {


        Row(
            modifier = Modifier
                .width(400.dp)
                .height(300.dp)
        ) {
            Card(
                modifier = Modifier
                    .width(200.dp)
                    .height(350.dp),
                elevation = 15.dp
            ) {
                Image(
                    painter = rememberImagePainter(data = poster),
                    contentScale = ContentScale.Crop,
                    contentDescription = title,
                    modifier = Modifier
                        .width(300.dp)
                        .fillMaxHeight()
                )
            }
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = title!!,
            modifier = Modifier.fillMaxWidth(),
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Type",
                modifier = Modifier.width(100.dp),
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = type!!,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black,
                fontSize = 20.sp
            )
        }

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Year",
                modifier = Modifier.width(100.dp),
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = year!!,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black,
                fontSize = 20.sp
            )
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(20.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
        ) {
            Text(
                text = "Imdb Id",
                modifier = Modifier.width(100.dp),
                color = Color.Black,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.width(5.dp))

            Text(
                text = imdbId!!,
                modifier = Modifier.fillMaxWidth(),
                color = Color.Black,
                fontSize = 20.sp
            )
        }
    }
}