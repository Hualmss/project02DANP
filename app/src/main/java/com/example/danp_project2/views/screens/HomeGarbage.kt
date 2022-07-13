package com.example.danp_project2.views.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*

import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
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
import com.example.danp_project2.data.DataForRoom.Garbage.GarbageViewModel
import com.example.danp_project2.data.DataForRoom.User.UserEntity
import com.example.danp_project2.navigation.AppScreens
import com.example.danp_project2.views.components.CardGarbegeHouse

@Composable
fun HomeGarbage(navController:NavController, garbageViewModel: GarbageViewModel){

    Scaffold(
        topBar = {
            TopAppBar() {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back",
                    modifier = Modifier.clickable {
                        navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(8.dp))
                Text("Basura de tu casa")
            }

        },
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
        BodyHGContent(/*navController*/garbageViewModel, navController)
    }
}

@Composable
fun BodyHGContent(garbageViewModel: GarbageViewModel, navController:NavController){
    Column (modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Header(garbageViewModel)
        BodyContent(garbageViewModel, navController)
    }
}
@Composable
fun Header(garbageViewModel: GarbageViewModel){
    var expanded by remember{ mutableStateOf(false) }
    val user = garbageViewModel.readAllDataUser.observeAsState(arrayListOf())
    Card(
        modifier = Modifier
            .padding(8.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(12.dp)
    ){
        Row(modifier= Modifier
            .padding(5.dp)
            .fillMaxWidth()){
            Image(
                painterResource(R.drawable.house),
                "profile image",
                modifier = Modifier
                    .clip(CircleShape)
                    .size(110.dp)
            )
            Column(modifier = Modifier.padding(5.dp)
            ){
                LazyColumn(
                    content = {
                        items(
                            items = user.value,
                            itemContent ={
                                Column(modifier = Modifier.clickable {
                                    expanded = !expanded
                                }) {
                                    printUser(it, if(expanded) Int.MAX_VALUE else 7)
                                }

                            }


                        )
                    }
                )
                //MyTexts("Usuario: "+ name)
                //MyTexts(text ="Pais: "+user.value.get(0).country)
                //MyTexts("Cantidad de basura:")
            }

        }
    }

}

@Composable
fun BodyContent(garbageViewModel: GarbageViewModel, navController:NavController){
    val garbages = garbageViewModel.readAllData.observeAsState(arrayListOf())
    LazyColumn(
        content = {
            items(
                items = garbages.value,
                itemContent ={ CardGarbegeHouse(garbage = it, garbageViewModel, navController) }

            )
        }
    )
    }


@Composable
fun MyTexts(text:String){
    Text(text, modifier = Modifier.padding(5.dp))
}

@Composable
fun printUser(user: UserEntity, lines:Int = Int.MAX_VALUE){
    if(lines == 7){
        Text(text = "Nombre: "+user.name+"\n" +
                "Apellido: "+user.lastname+"\n"+
                "Edad: "+user.age+"\n"+
                "Correo: "+user.email+"\n"+
                "Telefono: "+user.phoneNumber+"\n", color = Color.Black)
        return
    }
    val print:String ="Nombre: "+user.name+"\n" +
            "Apellido: "+user.lastname+"\n"+
            "Edad: "+user.age+"\n"+
            "Correo: "+user.email+"\n"+
            "Telefono: "+user.phoneNumber+"\n"+
            "Pais: "+user.country+"\n"+
            "Ciudad: "+user.city+"\n"+
            "Dirección: "+user.address+"\n"
    Text(print, color = Color.Gray, maxLines = lines)
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


