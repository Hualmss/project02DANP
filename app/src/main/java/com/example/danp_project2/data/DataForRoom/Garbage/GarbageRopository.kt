package com.example.danp_project2.data.DataForRoom.Garbage

import androidx.lifecycle.LiveData

class GarbageRopository(private val garbageDao: GarbageDao) {


    val reaAllData: LiveData<List<GarbageEntity>> = garbageDao.readAllData()


    suspend fun getGarbageById(id:Int): GarbageEntity{
        return garbageDao.getGarbageById(id)
    }

    suspend fun addGarbage(garbage: GarbageEntity){
        garbageDao.addGarbage(garbage)
    }

    suspend fun  updateGarbage(garbage:GarbageEntity){
        garbageDao.updateGarbage(garbage)
    }

    suspend fun deleteGarbage(garbage:GarbageEntity){
        garbageDao.deleteGarbage(garbage)
    }
}