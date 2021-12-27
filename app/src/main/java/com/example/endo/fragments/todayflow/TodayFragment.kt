package com.example.endo.fragments.todayflow

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import coil.load
import coil.transform.CircleCropTransformation
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.core.base.showToast
import com.example.db.models.WordsModel
import com.example.endo.R
import com.example.endo.adapters.WordsInTodayAdapter
import com.example.endo.databinding.FragmentTodayBinding
import com.example.endo.viewmodels.WordsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TodayFragment : BaseFragment<FragmentTodayBinding>(FragmentTodayBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<WordsModel> {
    private val adapter = WordsInTodayAdapter()
    private val TAG = "ololo"

    private val viewModel: WordsViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.insertData(WordsModel(wordInRussian = "Привет", wordInEnglish = "Hello"))

//        binding.myImage.load("https://ichef.bbci.co.uk/news/976/cpsprodpb/1852E/production/_121203699_2.63235180.jpg") {
//            crossfade(true)
//            placeholder(R.drawable.blue_gradient)
//            transformations(CircleCropTransformation())
//        }
    }

    override fun initAdapter() {
        adapter.listener = this
        binding.recentlyAddedWordsRecycler.adapter = adapter
        viewModel.viewModelScope.launch {
            viewModel.wordsModel.collect {
                if (it != null)
                    adapter.setData(it)
            }
        }
    }

    override fun onClick(model: WordsModel, position: Int) {
        val isClicked = false
        if (isClicked) {
            adapter.changeWordToEnglish(model)
            requireContext().showToast(position.toString() + "true")
        } else {
            requireContext().showToast(position.toString() + "false")
            adapter.changeWordToRussian(model)
        }
    }

    override fun initClickers() {

    }
}