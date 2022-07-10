package com.example.danp_project2.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.paging.ExperimentalPagingApi
import com.example.danp_project2.data.DataForDataStorage.SettingsViewModel
import com.example.danp_project2.data.DataForRoom.Garbage.GarbageViewModel
import com.example.danp_project2.views.screens.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi

@Composable
@InternalCoroutinesApi
@ExperimentalPagingApi
@ExperimentalCoroutinesApi
fun AppNavigation(settingsViewModel:SettingsViewModel ,prueba:Boolean){//ese será el encargado de orquestar la navegacion, conocer y gestioknar pasos entre ellas
    //para navegar se encuentran en una biblioteca a parte ne el gradle
    //2 elementos escenciales
    val navController= rememberNavController()//esta se encargará de gestionar el estado de navegacion entre ellas

    //NavHost(navController = navController, graph = )

    NavHost(navController = navController, startDestination =  if(prueba) AppScreens.UserInfo.route else AppScreens.HomeScreen.route){//este se encargará de conocer las pantallas y como navegar entre ellas

        composable(route = AppScreens.UserInfo.route){
            //val settingsViewModel = ViewModelProvider(navController.currentBackStackEntry!!)[SettingsViewModel::class.java]
            val garbageViewModel = ViewModelProvider(navController.currentBackStackEntry!!)[GarbageViewModel::class.java]
            userInfo(settingsViewModel, navController,garbageViewModel)
        }
        composable(route = AppScreens.HomeScreen.route){
            HomeScreen(navController)//se le apunta al elemento  composable
        }


        composable(route = AppScreens.HomeGarbage.route + "/{text}",//recive un nuevo parametro like url
            arguments = listOf(navArgument(name="text"){//la lista de argumentos
                type = NavType.StringType//tipos string
            })){

            val garbageViewModel = ViewModelProvider(navController.currentBackStackEntry!!)[GarbageViewModel::class.java]
            HomeGarbage(navController, garbageViewModel)
        }



        composable(route=AppScreens.AddGarbageScreen.route){
            val garbageViewModel = ViewModelProvider(navController.currentBackStackEntry!!)[GarbageViewModel::class.java]
            AddGarbageScreen(garbageViewModel,navController)
        }
        composable(route=AppScreens.WorldGarbage.route){
            //val garbageViewModel = ViewModelProvider(navController.currentBackStackEntry!!)[GarbageViewModel::class.java]
            //val product = Gson().fromJson(jsonProduct, Product::class.java)
            WorldGarbage(navController)
        }
        /*composable(
            route = AppScreens.WorldGarbage.route + "/{jsonProduct}",
            arguments = listOf(
                navArgument("jsonProduct") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val jsonProduct = backStackEntry.arguments?.getString("jsonProduct") ?: ""
            val product = Gson().fromJson(jsonProduct, GarbageEntity::class.java)
            WorldGarbage(
                navController = navController
            )
        }*/
        //WorldGarbage
    }
    //este navcontroller se tiee que propaar a todas la spantallas ya que este conoce el etsado de las pantallas
}