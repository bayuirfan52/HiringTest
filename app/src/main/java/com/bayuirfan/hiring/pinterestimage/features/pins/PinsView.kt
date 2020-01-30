package com.bayuirfan.hiring.pinterestimage.features.pins

import com.bayuirfan.hiring.pinterestimage.model.pins.Pins

interface PinsView {
    fun setPins(pins: ArrayList<Pins>)
    fun showLoading()
    fun hideLoading()
    fun showError(errorMessage: String)
}