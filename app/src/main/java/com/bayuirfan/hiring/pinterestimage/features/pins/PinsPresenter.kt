package com.bayuirfan.hiring.pinterestimage.features.pins

import com.bayuirfan.hiring.pinterestimage.api.ApiClient
import com.bayuirfan.hiring.pinterestimage.helper.safeApiCall
import com.bayuirfan.hiring.pinterestimage.model.Result
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PinsPresenter(private val view: PinsView) {
    fun getAllPins(){
        val service = ApiClient.getClient()
        view.showLoading()
        CoroutineScope(Dispatchers.Main).launch {
            val response = safeApiCall { service.getPins() }
            view.hideLoading()
            if (response is Result.Success){
                view.setPins(response.data.data.pins)
            } else if (response is Result.Error) {
                view.showError(response.throwable.localizedMessage)
            }
        }
    }
}