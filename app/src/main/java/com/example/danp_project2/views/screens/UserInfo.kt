package com.example.danp_project2.views.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.danp_project2.data.DataForDataStorage.SettingsViewModel
import com.example.danp_project2.navigation.AppScreens

@Composable
fun userInfo(garbageViewModel: SettingsViewModel, navController: NavController){
    val scrollState = rememberScrollState()
    Column(modifier = Modifier.padding(20.dp)
        .verticalScroll(scrollState),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)

    {
        var name by remember { mutableStateOf("") }
        var lastname by remember { mutableStateOf("") }
        var address by remember { mutableStateOf("") }
        var country by remember { mutableStateOf("") }
        var city by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var age by remember { mutableStateOf("") }

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Ingresar tu nombre") }
        )
        OutlinedTextField(
            value = lastname,
            onValueChange = { lastname = it },
            label = { Text("Ingresar tus apellidos") }
        )
        OutlinedTextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Ingresar tu direccion") }
        )
        OutlinedTextField(
            value = country,
            onValueChange = { country = it },
            label = { Text("Ingresar tu pais") }
        )
        OutlinedTextField(
            value = city,
            onValueChange = { city = it },
            label = { Text("Ingresa tu ciudad") }
        )
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("Ingresar tu numero telefonico") }
        )
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Ingresa tu correo electronico") }
        )
        OutlinedTextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Ingresar tu edad") }
        )

        Button(onClick = {
            garbageViewModel.saveToDataStoreFirstTime()
            navController.navigate(route= AppScreens.HomeScreen.route)
        }
        ) {
            Text(text = "Ingresar")
        }
    }

}