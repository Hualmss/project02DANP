package com.example.danp_project2.settings

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException



enum class UiMode{
    LIGHT, DARK, ECO
}

class SettingManager (context:Context) {
    private val Context.dataStore : DataStore<Preferences> by preferencesDataStore("settings")
    private val mDataStore:DataStore<Preferences> = context.dataStore

    val uiModelFlow: Flow<UiMode> = mDataStore.data
        .catch{
            if(it is IOException){
                it.printStackTrace()

            }else{
                throw it
            }
        }

        .map {preferences ->
            when(preferences[IS_DARK_MODE]?:false){
                true-> UiMode.DARK
                false-> UiMode.LIGHT
            }

        }



    companion object{
        val IS_DARK_MODE = booleanPreferencesKey("dark_mode")
    }

}