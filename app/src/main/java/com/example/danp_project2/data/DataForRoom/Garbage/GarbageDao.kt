package com.example.danp_project2.data.DataForRoom.Garbage

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface GarbageDao {
    @Insert
    suspend fun addGarbage(garbage: GarbageEntity)

    @Query("select * from garbage_table order by id asc")
    fun readAllData(): LiveData<List<GarbageEntity>>

}