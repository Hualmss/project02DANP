package com.example.danp_project2.views.screens

import android.text.style.BackgroundColorSpan
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.danp_project2.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.danp_project2.data.GarbageEntity
import com.example.danp_project2.data.GarbageViewModel
import com.example.danp_project2.navigation.AppScreens
import com.example.danp_project2.views.components.CardGarbegeHouse


@Composable
fun HomeGarbage(navController:NavController, garbageViewModel: GarbageViewModel){
    Log.d("", "HOla mundo ageno")
    Scaffold(
        floatingActionButton = {
            ExtendedFloatingActionButton(
                backgroundColor = Color(0xFF4BA04E),

                text = {
                    Text(text = "Basura", color = Color.White)
                },
                onClick = {
                    navController.navigate(route= AppScreens.AddGarbageScreen.route)
                }, icon = {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "image",
                        tint = Color.White
                    )
                })
        }
    ){
        /*val allGarbage = garbageViewModel.readAllData.observeAsState(arrayListOf())
        Text(text =allGarbage.toString())*/
        BodyHGContent(/*navController*/garbageViewModel)
    }
}

@Composable
fun BodyHGContent(garbageViewModel: GarbageViewModel){
    Column (modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Header()
        BodyContent(garbageViewModel)
    }
}
@Composable
fun Header(){
    Card(
        modifier = Modifier
            .padding(8.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(12.dp)
    ){
        Row(modifier=Modifier.padding(5.dp)){
            Image(
                painterResource(R.drawable.house),
                "profile image",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(150.dp)
            )
            Column(modifier = Modifier.padding(5.dp)){
                MyTexts("Usuario: ")
                MyTexts(text ="Huella de Carbono:")
                MyTexts("Cantidad de basura:")
            }

        }
    }

}

@Composable
fun BodyContent(garbageViewModel: GarbageViewModel){
    val garbages = garbageViewModel.readAllData.observeAsState(arrayListOf())
    LazyColumn(
        content = {
            items(
                items = garbages.value,
                itemContent ={ CardGarbegeHouse(garbage = it) }

            )
        }
    )
    }


@Composable
fun MyTexts(text:String){
    Text(text, modifier = Modifier.padding(5.dp))
}



@Preview(showSystemUi = true)
@Composable
fun Preview2(){
    Scaffold(){
        Column() {
            //BodyContent(/*navController*/)

        }
    }
    //HomeGarbage(/*navController*/)
}