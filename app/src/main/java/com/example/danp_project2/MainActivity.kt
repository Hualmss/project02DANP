package com.example.danp_project2

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import com.example.danp_project2.data.DataForDataStorage.SettingsViewModel
import com.example.danp_project2.navigation.AppNavigation
import com.example.danp_project2.settings.SettingManager
import com.example.danp_project2.settings.UiMode
import com.example.danp_project2.ui.theme.DANPproject2Theme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
@InternalCoroutinesApi
@ExperimentalPagingApi
@ExperimentalCoroutinesApi

class MainActivity : ComponentActivity() {

    private lateinit var settingManager: SettingManager
    private lateinit var settingsViewModel:SettingsViewModel
    @Inject
    lateinit var application: danp_project2

    var firstTime = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val FB = FirestorePaginSource()
        //FB.getData(applicationContext)
        settingsViewModel = SettingsViewModel(application)
        //settingManager = SettingManager(applicationContext)
        observeUiPreferences(settingsViewModel.uiDataStore)
        //setupUi()

        verify(settingsViewModel.uiDataStore)


        setContent {
            DANPproject2Theme(darkTheme=application.isDark.value)  {
                // A surface container using the 'background' color from the theme
                Surface(

                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar() {
                                Icon(imageVector = Icons.Default.Star, contentDescription = "Arrow Back",
                                    modifier = Modifier.clickable {
                                        setupUi()
                                    })
                                Spacer(modifier = Modifier.width(8.dp))
                                Text("Añade informacion de una nueva basura")
                            }

                        }
                    ){

                        //toast("holamundo "+application.isFIrstTime.value)
                        AppNavigation(settingsViewModel, application.isFIrstTime.value)
                    }

                }
            }
        }
    }
    private fun setupUi(){
        lifecycleScope.launch {
            when(application.isDark.value){
                true -> settingsViewModel.uiDataStore.setUiMode(UiMode.LIGHT)
                false -> settingsViewModel.uiDataStore.setUiMode(UiMode.DARK)
            }
        }
    }

    private fun observeUiPreferences( settingManager: SettingManager){
        settingManager.uiModelFlow.asLiveData().observe(this){
                uiMode ->
            uiMode?.let{
                when(uiMode){
                    UiMode.LIGHT -> onLightMode()
                    UiMode.DARK -> onDarkMode()

                }
            }
        }

    }


    private fun onLightMode(){
        application.isDark.value = false
    }

    private fun onDarkMode(){
        application.isDark.value = true

    }
    private fun verify(settingManager: SettingManager){



        lifecycleScope.launch{
            application.isFIrstTime.value = settingManager.firstTime.first()

        }
    }


    fun Context?.toast(text: CharSequence, duration: Int = Toast.LENGTH_LONG) = this?.let { Toast.makeText(it, text, duration).show() }

}


