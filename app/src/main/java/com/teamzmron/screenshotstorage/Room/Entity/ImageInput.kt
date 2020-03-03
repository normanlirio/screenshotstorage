package com.teamzmron.screenshotstorage.Room.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Timestamp

@Entity(tableName = "images")
class ImageInput (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") var id: Int? = null,

    @ColumnInfo(name = "image")
    var imageString: String? = null,

    @ColumnInfo(name = "timestamp")
    var timestamp: String? = null
)