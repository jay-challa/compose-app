package com.example.firstapp.view.components

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstapp.model.Track
import com.example.firstapp.view.ui.FirstAppTheme


@Composable
fun CoverImage(first: Track?,onClickStartSource : (first: Track) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable (onClick = { onClickStartSource(first!!) }),
    )  {
        first.let {
            if( it != null) {
                ImageComponent(
                    height = 180.dp,
                    path = it.images.background
                )

                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Bottom

                ) {
                    TitleText(title = it.title, color = Color.White)
                    SubTitleText(subtitle = it.subtitle, color = Color.White)
                }
            }
        }
    }
}
