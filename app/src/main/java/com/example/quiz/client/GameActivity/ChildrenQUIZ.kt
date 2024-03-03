package com.example.quiz.client.GameActivity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class ChildrenQUIZ(override val answear: MutableMap<Number, List<String>>) :QUIZ(answear), Parcelable  {

    init {

        answear[0] = listOf(
            "Двое идут в город. а навстречу им тоже двое. Сколько всего человек идут в город",
            "4",
            "3",
            "5",
            "2",
            "2"
        )
        answear[1] = listOf(
            "Летом серый, а зимой белый.",
            "Заяц",
            "Белка",
            "Лиса",
            "Волк",
            "Заяц"
        )
        answear[2] = listOf(
            "Зимой и летом одним цветом.",
            "Дуб",
            "Ёлка",
            "Берёза",
            "Яблоня",
            "Ёлка"
        )
        answear[3] = listOf(
            "Что принадлежит вам, но другие используют это чаще?",
            "Имя",
            "Телефон",
            "Одежда",
            "Микроволновка",
            "Имя"
        )
        answear[4] = listOf(
            "Идёт сегодня дождик,Бери с собою …!",
            "Зонтик",
            "Телефон",
            "Кошелёк",
            "Ключи",
            "Зонтик"
        )
        answear[5] = listOf("Вопрос 6", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
        answear[6] = listOf("Вопрос 7", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
        answear[7] = listOf("Вопрос 8", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
        answear[8] = listOf("Вопрос 9", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
        answear[9] = listOf("Вопрос 10", "Ответ 1", "Ответ 2", "Ответ 3", "Ответ 4", "Ответ 1")
    }

}