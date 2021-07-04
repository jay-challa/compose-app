package com.example.firstapp.view.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.firstapp.model.Track

@ExperimentalFoundationApi
@Composable
fun VerticalList(list: List<Track>?,onClickStartSource : (track : Track?) -> Unit){
    Surface {
        Column {
            TitleText(title = "Recommended list")
            LazyColumn {
                list.let {
                    if(it != null){
                        items(it.count()) { item  ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable (onClick = { onClickStartSource(it[item]) }),
                            ) {
                                ImageComponent(height = 150.dp,
                                    path = it[item].images.coverart)
                                Column(
                                    modifier = Modifier
                                        .padding(16.dp),
                                ) {

                                    TitleText(title = it[item].title,color = Color.White)
                                    SubTitleText(subtitle = it[item].subtitle,color = Color.White)

                                }
                            }

                        }
                    }
                }
            }
        }
    }
}


@ExperimentalFoundationApi
@Composable
fun HorizontalList(list: List<Track>?,onClickStartSource : (track : Track?) -> Unit){
    Surface {
        Column {
            TitleText(title = "Popular list")
            LazyRow {
                list.let {
                    if(it!=null){
                        items(it.count()) { item  ->
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable (onClick = { onClickStartSource(it[item]) }),
                            ) {
                                ImageComponentWithFixWidth(
                                    height = 150.dp,
                                    width = 300.dp,
                                    path = it[item].images.coverarthq)
                                Column(
                                    modifier = Modifier
                                        .padding(16.dp),
                                ) {
                                    TitleText(title = it[item].title,color = Color.White)
                                    SubTitleText(subtitle = it[item].subtitle,color = Color.White)

                                }
                            }
                        }
                    }
                }

            }
        }
    }
}