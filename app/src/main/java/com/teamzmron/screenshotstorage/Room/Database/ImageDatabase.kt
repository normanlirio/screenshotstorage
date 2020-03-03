package com.teamzmron.screenshotstorage.Room.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.teamzmron.screenshotstorage.Room.DAO.ImageDAO
import com.teamzmron.screenshotstorage.Room.Entity.ImageInput

@Database(entities = [ImageInput::class], version = 1, exportSchema = false)
abstract class ImageDatabase : RoomDatabase() {
    abstract fun imageDAO() : ImageDAO

    companion object {
        @Volatile
        private var databseInstance: ImageDatabase? = null

        @JvmStatic
        fun getDatabasenIstance(mContext: Context): ImageDatabase =
            databseInstance ?: synchronized(this) {
                databseInstance ?: buildDatabaseInstance(mContext).also {
                    databseInstance = it
                }
            }

        private fun buildDatabaseInstance(mContext: Context) =
            Room.databaseBuilder(mContext, ImageDatabase::class.java, "imagedb")
                .fallbackToDestructiveMigration()
                .build()

    }
}