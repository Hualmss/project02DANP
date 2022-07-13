package com.example.danp_project2.views.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.danp_project2.R
import com.example.danp_project2.navigation.AppScreens


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardHome(title: String, description: String, navController: NavController, screen:Int){
    Card(
        modifier = Modifier
            .padding(8.dp),// margin
        onClick =  {
            if (screen == 1) {
                navController.navigate(route=AppScreens.HomeGarbage.route +"/Este es un parametro")
            }else {
                navController.navigate(route=AppScreens.WorldGarbage.route)
            }
        },
        elevation = 8.dp,
        shape = RoundedCornerShape(12.dp)

    ) {
        Row(modifier = Modifier.padding(5.dp)
        ) {
            if(title.equals("Basura en casa")) {
                Image(
                    painterResource(R.drawable.bcasa),
                    "la basura en mi casa",
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primary)
                        .size(54.dp)//modificador
                )
                Column(modifier = Modifier.padding(start = 8.dp)) {
                    MyTexts(text = title, true)
                    Spacer(modifier = Modifier.width(8.dp))
                    MyTexts(text = description, false)
                }
            }
            if(title.equals("Basura del Mundo")) {
                Image(
                    painterResource(R.drawable.bmundo),
                    "la basura en mi casa",
                    modifier = Modifier
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primary)
                        .size(54.dp)//modificador
                )
                Column(modifier = Modifier.padding(start = 8.dp)) {
                    MyTexts(text = title, true)
                    Spacer(modifier = Modifier.width(8.dp))
                    MyTexts(text = description, false)
                }
            }
        }
    }


}

@Composable
fun MyTexts(text:String, title: Boolean){
    if(title)
        Text(text)
    else
        Text(text, color = Color.Gray)
}

@Preview
@Composable
fun preview(){
    //CardHome(title = "Basura en casa", "En esta sección podras encontrar y guardar la basura que se genera en tu hogar")
}

