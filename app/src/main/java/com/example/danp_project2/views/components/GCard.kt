package com.example.danp_project2.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.danp_project2.R
import com.example.danp_project2.data.DataForFIrebase.GarbageFB

@Composable
@InternalCoroutinesApi
@ExperimentalCoroutinesApi
fun GCard (
    garbage: GarbageFB,
    //onGarbageClick: (GarbageEntity) -> Unit
    ) {
    var expanded by remember{ mutableStateOf(false) }
        Card(

            shape = MaterialTheme.shapes.small,
            modifier = Modifier
                .padding(
                    start = 8.dp,
                    end = 8.dp,
                    top = 4.dp,
                    bottom = 4.dp
                )
                .fillMaxWidth(),
            elevation = 3.dp,
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 12.dp)
                    .clickable {
                        //onGarbageClick(garbage)
                        expanded = !expanded
                    },
                verticalAlignment = Alignment.CenterVertically,
            ){
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
                    .padding(end = 4.dp)
                    .clip(CircleShape)
                    .background(MaterialTheme.colors.primary)
                    .size(54.dp)//modificador
            )

                //garbage.name?.let { name ->
                    printCardGarbage(garbage = garbage,if(expanded)Int.MAX_VALUE else 1)
               // }
            }
        }
}

@Composable
fun printCardGarbage(garbage: GarbageFB, lines:Int = Int.MAX_VALUE){
    if(lines == 1){
        Text(text = "Nombre: "+garbage.name+"", color = Color.Black)
        return
    }
    val print:String ="Nombre: "+garbage.name+".\n"+
            "Tipo: "+garbage.type+".\n" +
            "Recyclave: "+garbage.recyclave+".\n" +
            "Tiempo de degradacion: "+garbage.degradation_time+" años"
    Text(print, color = Color.Gray, maxLines = lines)
}