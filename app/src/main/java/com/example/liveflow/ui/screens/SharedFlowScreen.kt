package com.example.liveflow.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.liveflow.ui.viewmodel.SharedFlowViewModel
import kotlinx.coroutines.flow.collectLatest

/*
SharedFlow
- Events, broadcast, one-time messages
- not lifecycle aware (doesn't respect activity lifecycle)
- Always ready to send
- no initial value
- uses collect
- Hot flow (always active)
- Radio: broadcast data to anyone listening
 */

// This screen is a Listener
@Composable
fun SharedViewModelScreen(){
    val context = LocalContext.current
    val viewModel: SharedFlowViewModel = viewModel()

    LaunchedEffect(Unit) {
        // mechanism to subscribe to the flow and listen to broadcast events
        viewModel.event.collectLatest { message->
            Toast.makeText(context,message, Toast.LENGTH_SHORT).show()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            fontSize = 30.sp,
            text="Hello")

        Button(onClick = {
            viewModel.onButtonClick()// on click broadcast the event from viewModel
        }) { Text("Click Me")}
    }


}


@Preview(showBackground = true)
@Composable
fun PreviewSharedViewModelScreen(){
    SharedViewModelScreen()
}