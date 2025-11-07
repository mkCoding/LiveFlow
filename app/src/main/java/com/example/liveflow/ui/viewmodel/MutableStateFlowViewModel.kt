package com.example.liveflow.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.collections.random

class MutableStateFlowViewModel: ViewModel(){
    val _userName = MutableStateFlow("Loading...")
    val userName: StateFlow<String> = _userName.asStateFlow()


    val randomNames = listOf<String>(
        "Alex", "Jordan", "Taylor", "Sam", "Riley",
        "Casey", "Morgan", "Jamie", "Charlie", "Dakota"
    )
    init{
        viewModelScope.launch {
            while (true) {
                delay(2000) // wait 2 seconds
                val randomName = randomNames.random()
                _userName.value = "Welcome, $randomName!"
            }
        }
    }




}