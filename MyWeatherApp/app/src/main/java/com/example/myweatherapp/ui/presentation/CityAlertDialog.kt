package com.example.myweatherapp.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import com.example.myweatherapp.ui.theme.Grey
import com.example.myweatherapp.ui.theme.LightGrey

@Composable
fun CityAlertDialog(dialogState: MutableState<Boolean>, onSubmit: (String)-> Unit){
    val dialogTextState = remember{
        mutableStateOf("")
    }
    AlertDialog(onDismissRequest = {
        dialogState.value=false
    },
        confirmButton = {
                TextButton(onClick = {
                    onSubmit(dialogTextState.value)
                    dialogState.value=false
                }) {
                    Text(text="Ok", color= Grey)
                }
    },
        dismissButton={
            TextButton(onClick = {
                dialogState.value=false
            }) {
                Text(text="Cancel", color= Grey)
            }
        },
        title = {
            Column(
                modifier= Modifier.fillMaxWidth()
            ){
                Text("Enter a city name:")
                TextField(value = dialogTextState.value
                    , onValueChange = {
                    dialogTextState.value=it
                },
                    shape= RectangleShape,
                    colors=TextFieldDefaults.colors(
                        disabledContainerColor = LightGrey,
                        focusedContainerColor=LightGrey,
                        unfocusedContainerColor= LightGrey,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        cursorColor = Grey
                    )
                )
            }
        }
    )
}