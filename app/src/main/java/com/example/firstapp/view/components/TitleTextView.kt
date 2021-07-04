package com.example.firstapp.view.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun TitleText(title : String){
    Text(
        text = title,
        style = MaterialTheme.typography.h6,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(bottom = 5.dp),
    )
}


@Composable
fun TitleText(title : String,color: Color){
    Text(
        text = title,
        color = color,
        style = MaterialTheme.typography.h6,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        modifier = Modifier.padding(bottom = 5.dp),
    )
}

@Composable
fun SubTitleText(subtitle : String , color: Color){
    Text(
        text = subtitle,
        color = color,
        modifier = Modifier
            .padding(bottom = 5.dp)

    )
}