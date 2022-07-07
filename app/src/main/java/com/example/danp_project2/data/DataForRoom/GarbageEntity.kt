package com.example.danp_project2.data.DataForRoom

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "garbage_table")
data class GarbageEntity (

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val degradation_time:String,
    val type: String,
    val description: String,
    val recyclave: String
)
