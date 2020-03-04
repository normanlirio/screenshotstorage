package com.teamzmron.screenshotstorage.Repository

import com.teamzmron.screenshotstorage.Room.Database.ImageDatabase
import com.teamzmron.screenshotstorage.Room.Entity.ImageInput
import com.teamzmron.screenshotstorage.ScreenshotStorageApplication
import io.reactivex.disposables.CompositeDisposable

class ImageRepository {

    private val compositeDisposable = CompositeDisposable()
    private fun getDBInstance(): ImageDatabase {
        return ImageDatabase.getDatabasenIstance(ScreenshotStorageApplication.getAppContext())
    }


    fun saveImageToRepo(imageInput: ImageInput) {
        getDBInstance().imageDAO().saveImage(imageInput)
    }
}