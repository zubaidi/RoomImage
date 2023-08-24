package com.zubaidi.roomimage.db

import kotlinx.coroutines.runBlocking

class ImageRepository(private val imageDAO: ImageDAO) {

    fun getAllImage(): List<ImageModel> = runBlocking {
        imageDAO.getImage()
    }

    fun insertImage(imageModel: ImageModel) = runBlocking {
        imageDAO.insertImage(imageModel)
    }

}