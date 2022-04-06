package com.example.endo.local

import com.example.endo.R
import com.example.endo.models.QuestionModel

class Client {
    fun getMovies(): List<QuestionModel> {

        val list = ArrayList<QuestionModel>()
        list.add(
            QuestionModel(
                R.raw.john_wick,
                "Что значит фраза You stabbed the devil in the back?",
                "Пустить ему нож в спину",
                "Попытаться убить демона",
                "Вы ударили демона в спину",
                "Убить демона",
                "Вы ударили демона в спину"
            )
        )
        list.add(
            QuestionModel(
                R.raw.dentist,
                "Как переводится Sir,there is no need for violence",
                "Сэр, здесь нету отсутствует нужда в насилии",
                "Сэр,тут нету нужды в насилии",
                "Сэр, нужда в насилии есть",
                "Сэр,в насилии нужда есть",
                "Сэр,тут нету нужды в насилии"
            )
        )
        list.add(
            QuestionModel(
                R.raw.harry_potter,
                "Что значит Excuse me, do you mind,everywhere else is full",
                "Извините, вы не против, везде все переполнено",
                "Простите, вы против, все уже полно",
                "Не прощаю, все не заполнено",
                "Прощаю,все полно",
                "Извините, вы не против, везде все переполнено"
            )
        )
        list.add(
            QuestionModel(
                R.raw.wonder,
                "Что значит Who is it that I aspire to be?",
                "Кем я желаю стать",
                "Что бы я хотел сделать",
                "Почему я хочу им быть",
                "Потому что я хочу быть им",
                "Кем я желаю стать"
            )
        )
        return list

    }

    fun getBooks(): List<QuestionModel> {

        val list = ArrayList<QuestionModel>()

        list.add(QuestionModel(R.raw.three_questions_tolstoy, "", "", "", "", "", ""))
        list.add(QuestionModel(R.raw.on_the_rainy_river, "", "", "", "", "", ""))
        list.add(QuestionModel(R.raw.the_boat, "", "", "", "", "", ""))
        list.add(QuestionModel(R.raw.art_of_war, "", "", "", "", "", ""))
        return list
    }
}