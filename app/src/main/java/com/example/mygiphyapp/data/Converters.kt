package com.example.mygiphyapp.data

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.room.TypeConverter
import com.example.mygiphyapp.data.models.Data
import com.example.mygiphyapp.data.models.Meta
import com.example.mygiphyapp.data.models.Pagination
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.ByteArrayOutputStream

class Converters {

    @TypeConverter
    fun toBitmap(bytes: ByteArray): Bitmap {
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
    }

    @TypeConverter
    fun fromBitmap(bmp: Bitmap): ByteArray {
        val outputStream = ByteArrayOutputStream()
        bmp.compress(Bitmap.CompressFormat.WEBP, 100, outputStream)
        return outputStream.toByteArray()
    }

    @TypeConverter
    fun fromList(dataList: List<Data>?): String? {
        return Gson().toJson(dataList)
    }

    @TypeConverter
    fun toList(dataListString: String?): List<Data>? {
        val type = object : TypeToken<List<Data>?>() {}.type
        return Gson().fromJson(dataListString, type)
    }

    @TypeConverter
    fun fromMeta(meta: Meta?): String? {
        return Gson().toJson(meta)
    }

    @TypeConverter
    fun toMeta(metaString: String?): Meta? {
        val type = object : TypeToken<Meta?>() {}.type
        return Gson().fromJson(metaString, type)
    }

    @TypeConverter
    fun fromPagination(pagination: Pagination?): String? {
        return Gson().toJson(pagination)
    }

    @TypeConverter
    fun toPagination(paginationString: String?): Pagination? {
        val type = object : TypeToken<Pagination?>() {}.type
        return Gson().fromJson(paginationString, type)
    }
}