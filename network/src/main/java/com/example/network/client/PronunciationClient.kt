package com.example.network.client

import com.example.network.models.PronunciationModel

class PronunciationClient {
    companion object {
        fun getList(): ArrayList<PronunciationModel> {
            val list = ArrayList<PronunciationModel>()
            list.add(PronunciationModel("meet my family"))
            list.add(PronunciationModel("Instagram"))
            list.add(PronunciationModel("my parents"))
            list.add(PronunciationModel("my elder brother"))
            list.add(PronunciationModel("my baby sister and me"))
            list.add(PronunciationModel("meet my Mom and Dad"))
            list.add(PronunciationModel("Jane and Michael"))
            list.add(PronunciationModel("my parents"))
            list.add(PronunciationModel("my parents"))
            list.add(PronunciationModel("my parents"))
            return list
        }
    }
}