package com.example.firstapp.view

import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.util.MutableBoolean
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstapp.Type
import com.example.firstapp.isNetworkConnected
import com.example.firstapp.model.SongResponse
import com.example.firstapp.model.Track
import com.example.firstapp.network.SongRetriever
import com.example.firstapp.network.getHeader
import com.example.firstapp.view.components.*
import com.example.firstapp.view.ui.FirstAppTheme
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private var resultList: SongResponse? = null

    @ExperimentalFoundationApi
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            if (isNetworkConnected(this)) {
                runBlocking {
                    withContext(Dispatchers.IO) {
                        resultList = SongRetriever().getList(getHeader())
                    }
                }
                ArtistCard()
            } else {
                var showNetworkAlert by rememberSaveable { mutableStateOf(false) }
                if(showNetworkAlert)
                    NoInternetAlert("No internet connected", onDismiss = { showNetworkAlert = false })
            }
        }
    }

    @ExperimentalFoundationApi
    @Composable
    fun ArtistCard() {
        Scaffold {
            Column(
                modifier = Modifier.padding(10.dp)
            ) {
                CoverImage(resultList?.tracks?.random(),onClickStartSource = {
                    startDetailActivity(Type.COVER,it)
                })
                HorizontalList(resultList?.tracks,onClickStartSource = {
                    startDetailActivity(Type.HORIZONTAL,it)
                })
                VerticalList(resultList?.tracks?.reversed(),onClickStartSource = {
                    startDetailActivity(Type.VERTICAL,it)
                })
            }
        }
    }

    private fun startDetailActivity(type : Type, track : Track?){
        var intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra("type",type)
        intent.putExtra("track",track)
        startActivity(intent)
    }

    @ExperimentalFoundationApi
    @Preview("Light Theme")
    @Preview("Dark Theme", uiMode = Configuration.UI_MODE_NIGHT_YES)
//    @Preview("Big font (big font)", fontScale = 1.5f)
//    @Preview("Large screen (large screen)", device = Devices.PIXEL_C)
    @Composable
    fun DefaultPreView() {
        FirstAppTheme {
            Surface {
                ArtistCard()
            }
        }
    }
}