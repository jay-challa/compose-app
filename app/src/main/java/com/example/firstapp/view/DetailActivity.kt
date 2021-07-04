package com.example.firstapp.view

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstapp.Type
import com.example.firstapp.model.Track
import com.example.firstapp.view.components.ImageComponent
import com.example.firstapp.view.components.ImageComponentWithFixWidth
import com.example.firstapp.view.components.SubTitleText
import com.example.firstapp.view.components.TitleText
import com.example.firstapp.view.ui.theme.FirstAppTheme

class DetailActivity : ComponentActivity() {
    private  var track : Track? = null
    private  var type : Type? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        type = intent.extras!!["type"] as Type?
        track = intent.extras!!["track"] as Track?
        setContent {
            LoadView()
        }
    }
    @Composable
    fun LoadView() {
        Column(
            modifier = Modifier.padding(10.dp)
        ){
            track.let {
                if(it != null){
                    var path = when(type){
                        Type.COVER->  it.images.background
                        Type.HORIZONTAL-> it.images.coverarthq
                        else -> it.images.coverart
                    }
                    Box(
                       modifier = Modifier.fillMaxSize()
                    ) {
                        ImageComponent(path = path)
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                                TitleText(title = it.title,color = Color.White)
                                SubTitleText(subtitle = it.subtitle,color = Color.White)
                                SubTitleText(subtitle = it.share.subject,color = Color.White)
                                SubTitleText(subtitle = it.share.text,color = Color.White)
                        }
                    }
                }
            }
        }
    }

    @Preview("Light Theme")
    @Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
    @Composable
    fun DefaultPreview() {
        FirstAppTheme {
            Surface {
                LoadView()
            }
        }
    }
}

