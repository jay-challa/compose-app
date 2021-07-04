package com.example.firstapp.model

import java.io.Serializable

data class SongResponse(
    val tracks: List<Track>
)

data class Track(
    val images: Images,
    val key: String,
    val layout: String,
    val share: Share,
    val subtitle: String,
    val title: String,
    val type: String
) : Serializable

data class Share(
    val avatar: String,
    val href: String,
    val html: String,
    val image: String,
    val snapchat: String,
    val subject: String,
    val text: String,
    val twitter: String
) : Serializable

data class Images(
    val background: String,
    val coverart: String,
    val coverarthq: String,
    val joecolor: String
) : Serializable