package com.example.gstore.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FavouriteEntity::class], version = 1)
abstract class DbRoom: RoomDatabase() {

    abstract val favouriteDao: FavouriteDao

    companion object {

        @Volatile
        private var INSTANCE: DbRoom? = null

        fun getDatabase(context: Context) : DbRoom {
            synchronized(this){
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DbRoom::class.java,
                        "Gstore Database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}