package com.example.endo.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.core.base.BaseFragment
import com.example.db.models.WordsModel
import com.example.endo.databinding.FragmentTodayBinding
import com.example.endo.viewmodels.WordsViewModel
import kotlinx.coroutines.flow.onEach


class TodayFragment : BaseFragment<FragmentTodayBinding>(FragmentTodayBinding::inflate) {

    private val viewModel: WordsViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.insertData(WordsModel(0, "hello", "Привет"))

        viewModel.wordsModel.onEach {
            it
        }
    }
}