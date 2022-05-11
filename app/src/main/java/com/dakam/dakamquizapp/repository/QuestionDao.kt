package com.dakam.dakamquizapp.repository

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface QuestionDao {
    @Insert
     fun addQuestion(question:Question)

    @Query("SELECT * FROM QUESTION")
      fun getAllQuestions():List<Question>

    @Insert
     fun addMultipleQuestions(vararg questions: Question)
}
