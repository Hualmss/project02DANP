package com.example.danp_project2.data.DataForRoom.Garbage

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface GarbageDao {
    @Insert
    suspend fun addGarbage(garbage: GarbageEntity)

    @Query("select * from garbage_table where id =:id")
    fun getGarbageById( id:Int): GarbageEntity

    @Query("select * from garbage_table order by id asc")
    fun readAllData(): LiveData<List<GarbageEntity>>


    @Update
    suspend fun updateGarbage(Ggarbage:GarbageEntity)

    @Delete
    suspend fun deleteGarbage(garbage: GarbageEntity)

}