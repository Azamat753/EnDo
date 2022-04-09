package com.example.endo.local

import com.example.db.R
import com.example.db.models.QuestionModel

class Client {
    fun getMusicByIndex(index: Int) {
        Client().getMusic().get(index).audio
    }

    fun getMusic(): List<QuestionModel> {

        val list = ArrayList<QuestionModel>()
        list.add(
            QuestionModel(
                R.raw.stay,
                "Что значит I do the same thing I told you that I never would",
                "Я делаю то же самое, что сказал тебе что никогда не буду",
                "Я буду делать то что сказал тебе что буду",
                "Я сказал делать буду",
                "Я сказал буду делать не буду",
                "Я делаю то же самое, что сказал тебе что никогда не буду"
            )
        )
        list.add(
            QuestionModel(
                R.raw.drown,
                "Что значит I'm drown in the pain, I'm drown in the rain ?",
                "Я в дожде тонуть буду ",
                "Я боль в дожде тонуть надо",
                " Дождь в боле тонуть",
                "Я тону в боли, я тону в дожде",
                "Я тону в боли, я тону в дожде"
            )
        )
        list.add(
            QuestionModel(
                R.raw.fairytale,
                "Что значит I don't care if I lose my mind",
                "Потерять разум все равно есть же",
                "Мне все равно если я начну странно вести себя",
                "Странно вести себя все равно если начну",
                "Разум жи есть потерять да ",
                "Мне все равно если я начну странно вести себя"
            )
        )
        list.add(
            QuestionModel(
                R.raw.old_town_road,
                "Что значит Ye, I'm gonna take my horse to the old town road?",
                "Лошадь возьму взять свою на древний дорога",
                "Взять лошадь дорога старая я ",
                "Я возьму свою лошадь на старую городскую дорогу",
                "Дорога старая возьму лошадь старая",
                "Я возьму свою лошадь на старую городскую дорогу"
            )
        )
        return list
    }

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

        list.add(
            QuestionModel(
                R.raw.three_questions_tolstoy,
                "If you always knew the right time to begin everything, if you knew who with the right people to listen to, and whom to avoid, and above all if you always knew what was the most important thing to do , he would never fail in anything he might undertake ",
                "Если ты всегда знал правильное время чтобы начать все, если ты знал к кому с правильными людьми прислушаться, и кого избегать, и превыше всего если ты всегда знал какую самую важную вещь надо сделать, он бы никогда не ошибся в том что он мог начать",
                "Всегда знал время правильно начать знал обратиться к кому",
                "Знал всегда время начать",
                "Начать время всегда знал",
                "Если ты всегда знал правильное время чтобы начать все, если ты знал к кому с правильными людьми прислушаться, и кого избегать, и превыше всего если ты всегда знал какую самую важную вещь надо сделать, он бы никогда не ошибся в том что он мог начать"
            )
        )
        list.add(
            QuestionModel(
                R.raw.on_the_rainy_river,
                "Что значит This is one story I've never told before",
                "",
                "",
                "",
                "",
                ""
            )
        )
        list.add(QuestionModel(R.raw.the_boat, "", "", "", "", "", ""))
        list.add(
            QuestionModel(
                R.raw.art_of_war,
                "Что значит It is a matter of life and death, a road either to safety or to ruin",
                "Дорога жизнь смерти к умереть",
                "Смерть дорога умереть",
                "Это вопрос жизни и смерти, дорога к безопасности либо к разрушению",
                "Разрушение смерть дорога",
                "Это вопрос жизни и смерти, дорога к безопасности либо к разрушению"

            )
        )
        return list
    }

}