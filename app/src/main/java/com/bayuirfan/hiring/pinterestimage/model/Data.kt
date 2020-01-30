package com.bayuirfan.hiring.pinterestimage.model

import com.bayuirfan.hiring.pinterestimage.model.pins.Pins
import com.bayuirfan.hiring.pinterestimage.model.user.User

data class Data (
    val user: User,
    val pins: ArrayList<Pins>
)