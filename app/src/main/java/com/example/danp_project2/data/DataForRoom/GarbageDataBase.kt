package com.example.danp_project2.data.DataForRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [GarbageEntity::class],
    version = 1,
    exportSchema = false
)
abstract class GarbageDataBase: RoomDatabase() {
    abstract fun garbageDao(): GarbageDao

    //access point to UI
    companion object{
        @Volatile
        private var INSTANCE: GarbageDataBase? = null

        fun getDatabase(context:Context): GarbageDataBase {
            val tmpInstance = INSTANCE
            if(tmpInstance != null){
                return tmpInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GarbageDataBase::class.java,
                    "garbage_db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }

    }
}