package com.example.danp_project2.data.DataForRoom.User

import androidx.lifecycle.LiveData
import com.example.danp_project2.data.DataForRoom.Garbage.GarbageEntity

class UserRepository (private val userDao: UserDao) {

    val reaAllData: LiveData<List<UserEntity>> = userDao.readAllData()

    suspend fun addUser(userEntity: UserEntity){
        userDao.addUser(userEntity)
    }
}