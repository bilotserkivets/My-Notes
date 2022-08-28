package com.example.mynotes.database.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mynotes.database.room.dao.NotesRoomDao
import com.example.mynotes.model.Category
import com.example.mynotes.model.Checklist
import com.example.mynotes.model.Note

@Database(entities = [Note::class, Checklist::class, Category::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase(){

    abstract fun getNotesRoomDao() : NotesRoomDao

    companion object {

        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getInstance(context: Context) : AppRoomDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            val instance = Room.databaseBuilder(
                context,
                AppRoomDatabase::class.java,
                "notebook_database"
            ).build()
            INSTANCE = instance
            return instance
        }
    }
}