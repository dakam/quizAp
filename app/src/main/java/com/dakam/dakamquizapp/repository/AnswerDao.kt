package com.dakam.dakamquizapp.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface AnswerDao {
    @Insert
     fun addAnswer(answer:Answer)
    @Query("SELECT * FROM Answer WHERE questionId = :qId")
     fun getQuestionAnswers(qId: Int):List<Answer>
    @Insert
     fun addMultipleAnswer(vararg answer: Answer)

    @Query("SELECT * FROM Answer ")
    fun getAllAnswers():List<Answer>
}