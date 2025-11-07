package com.example.liveflow.ui.screens

import androidx.compose.material3.*
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.unit.sp
import com.example.liveflow.ui.viewmodel.DataViewModel

/*
Live Data
 - Simple UI updates
 - Lifecycle aware (respects activity lifecycle)
 - Update only when screen is visible
 - Doesn't have initial value
 - Uses observe
 - only when visible
 - water bottle holds water and only released when its open (only flows when cap is open)
 */
@Composable
fun LiveDataScreen() {
    val viewModel: DataViewModel = viewModel()
    val count by viewModel.count.observeAsState(0)
    val liveDataStatus by viewModel.liveDataStatus.observeAsState("")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            fontSize = 30.sp,
            text = "Count: $count"
        )

        ElevatedButton(
            modifier = Modifier
                .padding(top = 16.dp),
            onClick = {
                viewModel.increaseLater()
            },
            colors = ButtonDefaults.elevatedButtonColors(
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            elevation = ButtonDefaults.elevatedButtonElevation(
                defaultElevation = 12.dp
            )
        ) {
            Text("Increase Count")
        }

        Text(
            text = liveDataStatus,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LiveDataScreenPreview() {
    LiveDataScreen()
}