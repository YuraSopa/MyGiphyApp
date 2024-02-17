package com.example.mygiphyapp.data.models


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "giphy_table")
data class GiphyResponse(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "data")
    @SerializedName("data")
    val `data`: List<Data>?,

    @ColumnInfo(name = "meta")
    @SerializedName("meta")
    val meta: Meta?,

    @ColumnInfo(name = "pagination")
    @SerializedName("pagination")
    val pagination: Pagination?
)
