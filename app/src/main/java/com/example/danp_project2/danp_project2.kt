package com.example.danp_project2

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.asLiveData
import com.example.danp_project2.settings.SettingManager
import com.example.danp_project2.settings.UiMode
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class danp_project2 : Application(){

    val isDark = mutableStateOf(true)
    val isFIrstTime = mutableStateOf(true)



}
