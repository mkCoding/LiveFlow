package com.example.liveflow.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose. foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.liveflow.ui.viewmodel.MutableStateFlowViewModel

/*
MutableStateFlow
- continuous data updates
- Not lifecycle Aware (doesn't respect activity lifecycle)
- Emitting even if screen isn't visible
- must have an initial value
- Uses collect
- Always ready
- River is always flowing (doesn't stop flowing)
 */

@Composable
fun MutableStateFlowScreen(){
    val viewModel: MutableStateFlowViewModel = viewModel()
    val retrievedUserState by viewModel.userName.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            fontSize = 30.sp,
            text= retrievedUserState
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewMutableStateFlowScreen(){
    MutableStateFlowScreen()
}