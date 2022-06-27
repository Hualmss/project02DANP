package com.example.danp_project2.views.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.danp_project2.R
import com.example.danp_project2.views.components.CardHome



@Composable
fun HomeScreen(navController: NavController){

    Scaffold(){
        BodyContent(navController)
    }

}

@Composable
fun BodyContent(navController: NavController){
    //listar cada card
    Column(  modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {
        Text("Bienvenido a Ecologiando", color= Color(41,201,39))
        Image(

            painterResource(R.drawable.logo),
            "isotipo",
            modifier= Modifier
                .clip(CircleShape)
                .size(324.dp)//modificador

        )
        CardHome(title = "Basura en casa", description = "Lista y averigua el impacto d ela basura que generas en casa",navController)

        //CardHome(title = "Basura del Mundo", description = "Averigua datos interesanteacerca de distintos desechos domesticos")
    }
}



@Preview
@Composable
fun Preview(){
    //HomeScreen()
}
