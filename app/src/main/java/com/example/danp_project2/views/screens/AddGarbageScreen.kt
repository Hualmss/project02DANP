package com.example.danp_project2.views.screens


import androidx.compose.foundation.layout.*

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.danp_project2.data.GarbageEntity
import com.example.danp_project2.data.GarbageViewModel


@Composable
fun AddGarbageScreen(garbageViewModel: GarbageViewModel){
    Scaffold(){
        BodyContentDGS(garbageViewModel)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BodyContentDGS(garbageViewModel: GarbageViewModel){
    Column(modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        var name by remember { mutableStateOf("") }
        var degration_time by remember { mutableStateOf("")}
        var description by remember { mutableStateOf("")}
        var type by remember { mutableStateOf("")}
        Text(text = "hola mundo")


        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Ingresar nombre de la basura") }
        )
        OutlinedTextField(
            value = degration_time,
            onValueChange = { degration_time = it },
            label = { Text("Ingresar el tiempo de la degradacion") }
        )
        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Ingresar una descripcion") }
        )
        OutlinedTextField(
            value = type,
            onValueChange = { type = it },
            label = { Text("Ingresar el tipo de basura") }
        )
        val options = listOf("Sí", "No")
        var expanded by remember { mutableStateOf(false) }
        var isRecyclave by remember { mutableStateOf(options[0]) }

        ExposedDropdownMenuBox(
            modifier = Modifier.padding(top=3.dp),
            expanded = expanded,
            onExpandedChange = {
                expanded = !expanded
            }
        ) {
            OutlinedTextField(
                readOnly = true,
                value = isRecyclave,
                onValueChange = { },
                label = { Text("select") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(
                        expanded = expanded
                    )
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                options.forEach { selectionOption ->
                    DropdownMenuItem(
                        onClick = {
                            isRecyclave = selectionOption
                            expanded = false
                        }
                    ) {
                        Text(text = selectionOption)
                    }
                }
            }
        }
        //

        Button(onClick = {
            val newGarbage = GarbageEntity(
                name = name,
                degradation_time = degration_time,
                description = description,
                recyclave = isRecyclave,
                type = type
            )
            garbageViewModel.addGarbage(newGarbage)

        }) {
            Text(text ="Guardar")
        }


    }

}

@Preview(showSystemUi = true)
@Composable
fun previewAGS(){
    //BodyContentDGS(null)
}
