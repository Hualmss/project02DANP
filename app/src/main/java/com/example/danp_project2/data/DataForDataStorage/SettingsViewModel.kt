package com.example.danp_project2.data.DataForDataStorage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.danp_project2.settings.SettingManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SettingsViewModel(application: Application): AndroidViewModel(application) {

    public val uiDataStore = SettingManager(application)

    fun saveToDataStoreFirstTime(){
        viewModelScope.launch(Dispatchers.IO) {
            uiDataStore.noFirstTime(false)
        }
    }




}