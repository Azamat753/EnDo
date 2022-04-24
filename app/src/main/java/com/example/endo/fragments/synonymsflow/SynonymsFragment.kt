package com.example.endo.fragments.synonymsflow

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.core.extensions.getDialog
import com.example.core.utils.CommonFunction
import com.example.db.models.SynonymsModel
import com.example.endo.R
import com.example.endo.activity.MainActivity
import com.example.endo.adapters.SynonymsAdapter
import com.example.endo.adapters.SynonymsDialogAdapter
import com.example.endo.bottomsheetdialogs.AddSynonymsBottomSheetDialog
import com.example.endo.databinding.FragmentSynonymsBinding
import com.example.endo.viewmodels.SynonymsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
@AndroidEntryPoint
class SynonymsFragment :
    BaseFragment<FragmentSynonymsBinding>(FragmentSynonymsBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<SynonymsModel> {
    private val args: SynonymsFragmentArgs by navArgs()
    private val viewModel: SynonymsViewModel by viewModels()
    private val adapter = SynonymsAdapter()
    private val synonymsDialogAdapter= SynonymsDialogAdapter()
    private var categoryName = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeToolbarTitle()
    }

    private fun changeToolbarTitle() {
        (requireActivity() as MainActivity).binding.toolbarMain.title = categoryName
    }

    override fun initClickers() {
        binding.addSynonymsFab.setOnClickListener {
            CommonFunction.showBottomSheet(
                AddSynonymsBottomSheetDialog(),
                requireActivity(),
                categoryName
            )
        }
    }


    override fun setArgsValue() {
        categoryName = args.synonymsCategoryModel.categoryName
    }

    override fun initAdapter() {
        binding.synonymsRecycler.adapter = adapter
        adapter.listener = this
    }

    override fun initObserver() {
        viewModel.getData(categoryName)
        viewModel.viewModelScope.launch {
            viewModel.synonymsModel.collect {
                if (it != null) {
                    adapter.setData(it)
                }
            }
        }
    }

    override fun onClick(model: SynonymsModel, position: Int) {
        val dialog = requireContext().getDialog(R.layout.synonyms_dialog)
        val synonymsWord = dialog.findViewById<TextView>(R.id.word)
        val closeBtn = dialog.findViewById<Button>(R.id.close_btn)
        val synonymRecycler= dialog.findViewById<RecyclerView>(R.id.synonyms_recycler)

        synonymsWord.text = model.synonymsWord
        synonymRecycler.adapter = synonymsDialogAdapter
        synonymsDialogAdapter.listener=this
        closeBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }
    }





