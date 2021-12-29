package com.example.endo.fragments.todayflow

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.core.base.showToast
import com.example.db.models.WordsModel
import com.example.endo.adapters.WordsInTodayAdapter
import com.example.endo.databinding.FragmentTodayBinding
import com.example.endo.viewmodels.WordsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodayFragment : BaseFragment<FragmentTodayBinding>(FragmentTodayBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<WordsModel> {
    private val adapter = WordsInTodayAdapter()
    private val TAG = "ololo"
    private var image = ""
    private val viewModel: WordsViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initAdapter() {
        adapter.listener = this
        binding.recentlyAddedWordsRecycler.adapter = adapter

        // TODO: 28.12.2021 рабочий
//        viewModel.viewModelScope.launch {
//            viewModel.wordsModel.collect {
//                if (it != null)
//                    adapter.setData(it)
//            }
//        }
    }

    override fun onClick(model: WordsModel, position: Int) {
        val isClicked = false
        if (isClicked) {
//            adapter.changeWordToEnglish(model)
            requireContext().showToast(position.toString() + "true")
        } else {
            requireContext().showToast(position.toString() + "false")
//            adapter.changeWordToRussian(model)
        }
    }

    override fun initClickers() {

    }

    override fun initObserver() {

    }
}