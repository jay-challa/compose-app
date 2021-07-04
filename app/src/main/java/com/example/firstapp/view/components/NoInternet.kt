package com.example.firstapp.view.components

import androidx.compose.material.AlertDialog
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable

@Composable
fun NoInternetAlert(string: String,  onDismiss: () -> Unit){
    AlertDialog(
        onDismissRequest = onDismiss,
        text = {
            Text(
                text = string,
                style = MaterialTheme.typography.body2
            )
        },
        confirmButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "CLOSE")
            }
        }
    )
}