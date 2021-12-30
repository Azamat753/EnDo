package com.example.endo.fragments.dictionaryflow

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.core.utils.CommonFunction
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.core.extensions.getDialog
import com.example.db.models.WordsModel
import com.example.endo.R
import com.example.endo.activity.MainActivity
import com.example.endo.adapters.WordsAdapter
import com.example.endo.bottomsheetdialogs.AddWordsBottomSheetDialog
import com.example.endo.databinding.FragmentWordsBinding
import com.example.endo.viewmodels.WordsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WordsFragment : BaseFragment<FragmentWordsBinding>(FragmentWordsBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<WordsModel> {
    private val args: WordsFragmentArgs by navArgs()
    private val viewModel: WordsViewModel by viewModels()
    private val adapter = WordsAdapter()
    private var categoryName = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeToolbarTitle()
    }

    private fun changeToolbarTitle() {
        (requireActivity() as MainActivity).binding.toolbarMain.title = categoryName
    }

    override fun initClickers() {
        binding.addWordFab.setOnClickListener {
            CommonFunction.showBottomSheet(
                AddWordsBottomSheetDialog(),
                requireActivity(),
                categoryName
            )
        }
    }

    override fun setArgsValue() {
        categoryName = args.dictionaryCategoryModel.categoryName
    }

    override fun initAdapter() {
        binding.wordsRecycler.adapter = adapter
        adapter.listener = this
    }

    override fun initObserver() {
        viewModel.getData(categoryName)
        viewModel.viewModelScope.launch {
            viewModel.wordsModel.collect {
                if (it != null) {
                    adapter.setData(it)
                }
            }
        }
    }

    override fun onClick(model: WordsModel, position: Int) {
        val dialog = requireContext().getDialog(R.layout.translate_with_image_dialog)
        val image = dialog.findViewById<ImageView>(R.id.image)
        val closeBtn = dialog.findViewById<Button>(R.id.close_btn)
        val translateWord = dialog.findViewById<TextView>(R.id.translate_word)

        image.load(model.image)
        translateWord.text = model.wordInRussian
        closeBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }
}