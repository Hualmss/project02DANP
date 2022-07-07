package com.example.danp_project2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.paging.ExperimentalPagingApi
import com.example.danp_project2.navigation.AppNavigation
import com.example.danp_project2.ui.theme.DANPproject2Theme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@AndroidEntryPoint
@InternalCoroutinesApi
@ExperimentalPagingApi
@ExperimentalCoroutinesApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val FB = FirestorePaginSource()
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



