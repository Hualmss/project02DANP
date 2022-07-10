package com.example.danp_project2.data.DataForRoom.User

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.danp_project2.data.DataForRoom.Garbage.GarbageEntity


@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: UserEntity)

    @Query("select * from user_table order by id asc")
    fun readAllData(): LiveData<List<UserEntity>>


}