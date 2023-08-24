package com.zubaidi.roomimage.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ImageDAO {
    @Query("SELECT * FROM ImageModel")
    fun getImage() : List<ImageModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImage(imageModel: ImageModel)

}