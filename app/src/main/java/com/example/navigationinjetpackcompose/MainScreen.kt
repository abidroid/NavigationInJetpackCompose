package com.example.navigationinjetpackcompose

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {

    val txtName = remember {
        mutableStateOf("")
    }

    var myContext = LocalContext.current

    Scaffold(

        topBar = {
            TopAppBar(
                title = { Text(text = "Home Screen", color = Color.White) },
                colors = topAppBarColors(Color.Blue),
            )
        },

        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)

                    .background(color = Color.White),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                Text(
                    text = "Hello !",
                    //modifier = modifier
                )
                Button(onClick = {
                    navController.navigate("SecondScreen")
                }) {
                    Text("Go to Second Screen")
                }
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {
                    navController.navigate("ThirdScreen")
                }) {
                    Text("Go to Third Screen")
                }

                Spacer(modifier = Modifier.height(16.dp))

                TextField(value = txtName.value, onValueChange = { text: String ->
                    txtName.value = text
                })
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = {

                    //Note: We can also use try catch for illegal argument exception
                    //and show error message
                    if (txtName.value.isEmpty()) {
                        Toast.makeText(myContext, "Please enter your name", Toast.LENGTH_SHORT).show()
                    } else {
                        navController.navigate("FourthScreen/${txtName.value}")

                    }
                }) {
                    Text("Go to Fourth Screen")
                }
            }
        }
    )
}

//@Preview
//@Composable
//fun MainScreenPreview() {
//    MainScreen(NavController())
//}