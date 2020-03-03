package com.teamzmron.screenshotstorage.Room.DAO

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.teamzmron.screenshotstorage.Room.Entity.ImageInput
import io.reactivex.Flowable
import io.reactivex.Single


@Dao
interface ImageDAO {

    @Insert(onConflict = REPLACE)
    fun saveImage(imageInput : ImageInput) : Single<Long>

    @Query("SELECT * from images ORDER BY timestamp ASC")
    fun getSavedImages() : Flowable<List<ImageInput>>
}
