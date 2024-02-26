package com.example.quiz.client.GameActivity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class LogicQuiz(override val answear: MutableMap<Number, List<String>>
) :QUIZ(answear), Parcelable {

    init {
        checkAnswear.fill(0)
        answear[0] = listOf("Вопрос 1", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
        answear[1] = listOf("Вопрос 2", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
        answear[2] = listOf("Вопрос 3", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
        answear[3] = listOf("Вопрос 4", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
        answear[4] = listOf("Вопрос 5", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
        answear[5] = listOf("Вопрос 6", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
        answear[6] = listOf("Вопрос 7", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
        answear[7] = listOf("Вопрос 8", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
        answear[8] = listOf("Вопрос 9", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
        answear[9] = listOf("Вопрос 10", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
    }
}