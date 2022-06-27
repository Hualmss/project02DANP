package com.example.danp_project2.data

import androidx.lifecycle.LiveData

class GarbageRopository(private val garbageDao: GarbageDao) {


    val reaAllData: LiveData<List<GarbageEntity>> = garbageDao.readAllData()


    suspend fun addGarbage(garbage: GarbageEntity){
        garbageDao.addGarbage(garbage)
    }
}