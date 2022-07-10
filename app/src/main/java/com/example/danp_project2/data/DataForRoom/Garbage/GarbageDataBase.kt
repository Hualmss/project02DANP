package com.example.danp_project2.data.DataForRoom.Garbage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.danp_project2.data.DataForRoom.User.UserDao
import com.example.danp_project2.data.DataForRoom.User.UserEntity

@Database(entities = [GarbageEntity::class, UserEntity::class],
    version = 2,
    exportSchema = false
)
abstract class GarbageDataBase: RoomDatabase() {
    abstract fun garbageDao(): GarbageDao
    abstract fun userDao():UserDao

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
                ) .fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }

    }
}