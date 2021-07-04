package com.example.firstapp.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.google.accompanist.coil.rememberCoilPainter

@Composable
fun ImageComponent(height : Dp, path : String){
    Image(
        painter = rememberCoilPainter (path),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .padding(bottom = 16.dp)
            .clip(shape = RoundedCornerShape(4.dp))

    )
}

@Composable
fun ImageComponent(path : String){
    Image(
        painter = rememberCoilPainter (path),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .clip(shape = RoundedCornerShape(4.dp))
    )
}

@Composable
fun ImageComponentWithFixWidth(height : Dp,width: Dp, path : String){
    Image(
        painter = rememberCoilPainter(path),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .height(height)
            .width(width)
            .padding(end = 16.dp, bottom = 16.dp)
            .clip(shape = RoundedCornerShape(4.dp))

    )
}