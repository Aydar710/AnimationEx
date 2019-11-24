package com.animationex.data

import androidx.annotation.DrawableRes
import java.io.Serializable

data class Item(
    val id : Int,
    val title: String,
    @DrawableRes
    val image: Int
) : Serializable
