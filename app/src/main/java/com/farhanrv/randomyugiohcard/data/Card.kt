package com.farhanrv.randomyugiohcard.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Card(
    val id: Int,
    val name: String,
    val desc: String,
    val image_url_small: String
) : Parcelable
