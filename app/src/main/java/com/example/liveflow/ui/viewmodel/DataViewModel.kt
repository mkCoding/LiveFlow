package com.example.liveflow.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataViewModel(): ViewModel(){

    // Simple UI updates in Android apps
    // Update Data when screen is visible

    private val _count = MutableLiveData(0)
    val count: LiveData<Int> = _count

    private val _liveDataStatus = MutableLiveData("")
    val liveDataStatus: LiveData<String> =_liveDataStatus


    // Live Data Methods
    fun increaseCount(){
        _count.value = _count.value?.plus(1)
    }

    fun increaseLater() {
        Thread {
            _liveDataStatus.postValue( "doing background work...")
            Thread.sleep(3000) // background work being done
            _count.postValue((_count.value ?: 0) + 1)
            _liveDataStatus.postValue( "Done!")
        }.start()
    }



}