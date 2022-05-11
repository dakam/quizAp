package com.dakam.dakamquizapp.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Question(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "qtn") val qtn :String
)
