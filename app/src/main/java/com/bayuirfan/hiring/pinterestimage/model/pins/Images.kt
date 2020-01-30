package com.bayuirfan.hiring.pinterestimage.model.pins

import com.google.gson.annotations.SerializedName

data class Images (
    @SerializedName("237x")
    val sizeSmall: Size,

    @SerializedName("564x")
    val sizeMedium: Size
)