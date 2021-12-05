package com.example.contreyandflag


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contreyandflag.network.CountryResPONSE

import com.example.contreyandflag.network.FlagApi
import com.example.contreyandflag.network.FlagPhoto
import kotlinx.coroutines.launch

class FlagViewModel:ViewModel() {
    private val _status = MutableLiveData<String>()
    val status:LiveData<String> = _status

    private var _countryPhotos = MutableLiveData<List<FlagPhoto>>()
    val countryPhotos: LiveData<List<FlagPhoto>> = _countryPhotos

    init {
        getFlagPhotos()
    }
    private fun getFlagPhotos(){
    viewModelScope.launch {
        try {
            _countryPhotos.value = FlagApi.retrofitService.getPhotos().data
            _status.value = "Success"
        }catch (e:Exception){
            _status.value = "Failure: ${e.message}"

        }
    }
    }

}