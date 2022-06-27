package com.example.danp_project2.views.components

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.danp_project2.R
import com.example.danp_project2.data.GarbageEntity
import com.example.danp_project2.navigation.AppScreens

@Composable
fun CardGarbegeHouse(garbage:GarbageEntity) {
    Column(/*modifier = Modifier.padding(5.dp)*/) {
        BodyContent(garbage)
    }
}

@Composable
fun BodyContent(garbage:GarbageEntity){
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
        Row(modifier = Modifier.padding(5.dp)
        ) {
            Image(
                painterResource(R.drawable.ic_launcher_foreground),
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
        }
    }
}

@Composable
fun printGarbage(garbage:GarbageEntity, lines:Int = Int.MAX_VALUE){
    val print:String ="Descripcion:\n"+garbage.description+".\n" +
            "Tipo: "+garbage.type+".\n" +
            "Recyclave: "+garbage.recyclave+".\n" +
            "Tiempo de degradacion: "+garbage.degradation_time
    Text(print, color = Color.Gray, maxLines = lines)
}








@Preview(showSystemUi = true)
@Composable
fun previewF(){
    //BodyContent()
}