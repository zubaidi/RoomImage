package com.zubaidi.roomimage.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.*
import java.io.ByteArrayOutputStream
import java.lang.Exception

object BitmapConverter {

    fun convertBitmapToString(bitmap: Bitmap) : String {
        val baos = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 70, baos)
        val byteArray = baos.toByteArray()
        return Base64.encodeToString(byteArray, Base64.DEFAULT)
    }

    fun convertStringToBitmap(encodeString: String) : Bitmap? {
        return try {
            val encodeByte = Base64.decode(encodeString, Base64.DEFAULT)
            BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.size)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }

}