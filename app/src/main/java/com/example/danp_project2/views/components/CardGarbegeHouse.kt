package com.example.danp_project2.views.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.danp_project2.R
import com.example.danp_project2.data.DataForFIrebase.GarbageFB
import com.example.danp_project2.data.DataForRoom.Garbage.GarbageEntity
import com.example.danp_project2.data.DataForRoom.Garbage.GarbageViewModel
import com.example.danp_project2.data.DataForRoom.User.UserEntity
import com.example.danp_project2.navigation.AppScreens
import com.example.danp_project2.views.screens.MyTexts

@Composable
fun CardGarbegeHouse(garbage: GarbageEntity, garbageViewModel: GarbageViewModel, navController: NavController) {
    Column(/*modifier = Modifier.padding(5.dp)*/) {
        BodyContent(garbage, garbageViewModel, navController)
    }
}

@Composable
fun BodyContent(garbage: GarbageEntity, garbageViewModel: GarbageViewModel, navController:NavController){
    //val scrollState = rememberScrollState()
    var expanded by remember{ mutableStateOf(false)}
    Card(
        modifier = Modifier
            .padding(8.dp)//.verticalScroll(scrollState)
            .fillMaxWidth()
        ,// margin


        elevation = 8.dp,
        shape = RoundedCornerShape(12.dp)

    ) {
        Row(modifier = Modifier.padding(5.dp).fillMaxWidth()
        ) {
            Image(
                painterResource(
                    if(garbage.type=="metal") {
                        R.drawable.metal
                    }else if(garbage.type=="plastico"){
                        R.drawable.plastic
                    }else if(garbage.type=="organico"){
                        R.drawable.organico
                    }else if(garbage.type=="electronico"){
                        R.drawable.baterias
                    }else {
                        R.drawable.papel
                    }
                ),
                "la basura en mi casa",
                modifier= Modifier
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.primary)
                    .size(54.dp)//modificador
            )
            Column(modifier = Modifier.padding(start = 8.dp)
                .clickable {
                    expanded = !expanded
                }) {
                MyTexts(text = garbage.name, true)
                Spacer(modifier = Modifier.width(8.dp))

                printGarbage(garbage = garbage,if(expanded)Int.MAX_VALUE else 1)


            }
            Column(modifier = Modifier.padding(start = 1.dp)
                .clickable {
                    expanded = !expanded
                }.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete",
                    modifier = Modifier.clickable {
                        garbageViewModel.deleteItem(garbage)
                    }.padding(2.dp))
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Delete",
                    modifier = Modifier.clickable {
                        //val id = garbageViewModel.getGarbageById(garbage.id)
                        //navController.navigate(route= AppScreens.AddGarbageScreen.route+"/"+id)
                    })
            }

        }
    }
}

@Composable
fun printGarbage(garbage: GarbageEntity, lines:Int = Int.MAX_VALUE){

    val print:String ="Descripcion: "+garbage.description+".\n" +
            "Tipo: "+garbage.type+".\n" +
            "Recyclave: "+garbage.recyclave+".\n" +
            "Tiempo de degradacion: "+garbage.degradation_time + " años"
    Text(print, color = Color.Gray, maxLines = lines)
}









@Preview(showSystemUi = true)
@Composable
fun previewF(){
    //BodyContent()
}