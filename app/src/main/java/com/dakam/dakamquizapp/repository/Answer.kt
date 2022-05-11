package com.dakam.dakamquizapp.repository

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Answer (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val questionId: Int,
    @ColumnInfo(name = "ans") val ans :String
)