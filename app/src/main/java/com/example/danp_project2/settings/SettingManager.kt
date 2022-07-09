package com.example.danp_project2.settings

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.booleanPreferencesKey

import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.io.IOException



enum class UiMode{
    LIGHT, DARK
}



class SettingManager (context:Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("settings")
    private val mDataStore: DataStore<Preferences> = context.dataStore





    val firstTime:Flow<Boolean> =
    mDataStore.data.catch{
        if(it is IOException){
            it.printStackTrace()

        }else{
            throw it
        }
    }.map {
            preferences ->
        val res = preferences[IS_FIRST_TIME] ?: true
        res
    }
    suspend fun noFirstTime(valor:Boolean){
        mDataStore.edit { preferences->
            preferences[IS_FIRST_TIME]=when(valor){
                true -> false
                false -> false
            }

        }

    }
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
    suspend fun setUiMode(uiMode:UiMode){
        mDataStore.edit { preferences->
            preferences[IS_DARK_MODE] = when(uiMode){
                UiMode.LIGHT -> false
                UiMode.DARK -> true
            }
        }
    }



    companion object{
        val IS_DARK_MODE = booleanPreferencesKey("dark_mode")
        val IS_FIRST_TIME = booleanPreferencesKey("first_time")

    }

}