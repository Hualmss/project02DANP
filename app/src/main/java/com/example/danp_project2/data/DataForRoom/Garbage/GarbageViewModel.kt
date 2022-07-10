package com.example.danp_project2.data.DataForRoom.Garbage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.danp_project2.data.DataForRoom.User.UserEntity
import com.example.danp_project2.data.DataForRoom.User.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class GarbageViewModel(application: Application): AndroidViewModel(application) {

    val readAllData : LiveData<List<GarbageEntity>>
    val readAllDataUser : LiveData<List<UserEntity>>
    private val repository: GarbageRopository
    private val repository2: UserRepository


    init{
        val garbageDao = GarbageDataBase.getDatabase(application).garbageDao()
        val userDao = GarbageDataBase.getDatabase(application).userDao()
        repository2 = UserRepository(userDao)
        repository = GarbageRopository(garbageDao)
        readAllData = repository.reaAllData
        readAllDataUser = repository2.reaAllData

    }


    fun addGarbage(garbage: GarbageEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository
                .addGarbage(garbage)
        }
    }

    fun addUser(user:UserEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository2
                .addUser(user)
        }
    }

    fun updateItem(garbage: GarbageEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateGarbage(garbage)
        }
    }



    fun deleteItem(garbage: GarbageEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteGarbage(garbage)
        }
    }



}