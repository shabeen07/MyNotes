package com.shabeen07.my_notes.respository.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.shabeen07.my_notes.models.NoteDto
import com.shabeen07.my_notes.respository.database.dao.NoteDao

@Database(entities = [NoteDto::class], version = 1, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun noteDao(): NoteDao

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        // if the INSTANCE is not null, then return it, if it is, then create the database
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room
                    .databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "app_database"
                    )
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

    }

}