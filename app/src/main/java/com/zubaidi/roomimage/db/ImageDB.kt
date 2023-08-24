package com.zubaidi.roomimage.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [ImageModel::class], version = 1, exportSchema = false)
abstract class ImageDB : RoomDatabase(){

    abstract val imageDAO: ImageDAO

    companion object {
        @Volatile
        private var INSTANCE : ImageDB ?= null
        private var key = Any()
        operator fun invoke(context: Context) = INSTANCE ?: synchronized(key) {
            INSTANCE ?: buildDatabase(context).also {
                INSTANCE = it
            }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ImageDB::class.java, "IMAGE_DB"
        ).fallbackToDestructiveMigration().allowMainThreadQueries().build()
    }

}