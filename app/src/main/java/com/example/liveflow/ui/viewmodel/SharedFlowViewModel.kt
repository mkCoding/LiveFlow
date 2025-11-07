package com.example.liveflow.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class SharedFlowViewModel: ViewModel(){
    private val _event = MutableSharedFlow<String>() //no initial value
    val event =_event.asSharedFlow()

    // emit an event
    fun onButtonClick(){
        viewModelScope.launch {
            // this will be collected by UI listener
            _event.emit("Button was clicked!")
        }
    }
}