package com.noweaj.android.terminalmacro.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.noweaj.android.terminalmacro.data.entity.MacroEntity

@Database(entities = [MacroEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun macroDao(): MacroDao
    
    companion object{
        private val DB_NAME = "terminalmacro-db"
        private var instance: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            return instance?: synchronized(this){
                instance?: buildDatabase(context)
            }
        }
        
        private fun buildDatabase(context: Context): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DB_NAME
            ).addCallback(object: RoomDatabase.Callback(){}).build()
        }
    }
}