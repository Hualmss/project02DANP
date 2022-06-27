package com.example.danp_project2.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GarbageViewModel(application: Application): AndroidViewModel(application) {

    val  readAllData : LiveData<List<GarbageEntity>>
    private val repository: GarbageRopository


    init{
        val garbageDao = GarbageDataBase.getDatabase(application).garbageDao()
        repository = GarbageRopository(garbageDao)
        readAllData = repository.reaAllData
    }


    fun addGarbage(garbage:GarbageEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository
                .addGarbage(garbage)
        }
    }

}