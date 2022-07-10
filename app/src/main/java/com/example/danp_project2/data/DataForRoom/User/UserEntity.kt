package com.example.danp_project2.data.DataForRoom.User

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user_table")
data class UserEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val lastname:String,
    val address: String,
    val country: String,
    val city:String,
    val phoneNumber:String,
    val email:String,
    val age:String

    )

    /*
    *  var name by remember { mutableStateOf("") }
        var lastname by remember { mutableStateOf("") }
        var address by remember { mutableStateOf("") }
        var country by remember { mutableStateOf("") }
        var city by remember { mutableStateOf("") }
        var phoneNumber by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var age by remember { mutableStateOf("") }*/



