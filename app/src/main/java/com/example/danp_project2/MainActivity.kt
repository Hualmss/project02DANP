package com.example.danp_project2

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.danp_project2.data.FireBaseMG
import com.example.danp_project2.navigation.AppNavigation
import com.example.danp_project2.ui.theme.DANPproject2Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val FB = FireBaseMG()
        //FB.getData(applicationContext)

        setContent {
            DANPproject2Theme(darkTheme=2)  {
                // A surface container using the 'background' color from the theme
                Surface(

                ) {

                    AppNavigation()
                }
            }
        }
    }
}



