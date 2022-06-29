package com.example.danp_project2.navigation

sealed class AppScreens (val route: String){
    object HomeScreen: AppScreens("HomeScreen")
    object HomeGarbage: AppScreens("HomeGarbage")
    object AddGarbageScreen: AppScreens("AddGarbageScreen")
    object WorldGarbage: AppScreens("WorldGarbage")
}
