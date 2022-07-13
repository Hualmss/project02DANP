package com.example.danp_project2.views.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.danp_project2.data.DataForDataStorage.SettingsViewModel
import com.example.danp_project2.data.DataForRoom.Garbage.GarbageViewModel
import com.example.danp_project2.data.DataForRoom.User.UserEntity
import com.example.danp_project2.navigation.AppScreens
import kotlinx.coroutines.withContext

@Composable
fun userInfo(settingsViewModel: SettingsViewModel, navController: NavController,garbageViewModel: GarbageViewModel){
    val scrollState = rememberScrollState()
    Text(
        "Registra tus datos a Ecologia Verde",
        style = TextStyle(
            textAlign = TextAlign.Center,
            fontSize = 35.sp
        )
    )
    Spacer(modifier = Modifier.width(18.dp))
    Column(modifier = Modifier
        .padding(65.dp)
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
            if (name != "" &&
                lastname!= "" &&
                address!= "" &&
                country!= "" &&
                city!= "" &&
                phoneNumber!= "" &&
                email!= "" &&
                age!= ""
            ) {
                val newUser = UserEntity(
                    name = name,
                    lastname = lastname,
                    address = address,
                    country = country,
                    city = city,
                    phoneNumber = phoneNumber,
                    email = email,
                    age = age
                )
                garbageViewModel.addUser(newUser)
                settingsViewModel.saveToDataStoreFirstTime()
                navController.navigate(route = AppScreens.HomeScreen.route)
                val toast = Toast.makeText(navController.context, "Usuario registrado correctamente", Toast.LENGTH_LONG)
                toast.show()
            }
            else{
                val toast = Toast.makeText(navController.context, "Ingrese sus datos correctamente", Toast.LENGTH_LONG)
                toast.show()
            }
        }
        ) {
            Text(text = "Ingresar")
        }
    }

}