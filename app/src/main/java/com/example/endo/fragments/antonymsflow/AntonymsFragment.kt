package com.example.endo.fragments.antonymsflow

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
import com.example.db.models.AntonymsModel
import com.example.endo.R
import com.example.endo.activity.MainActivity
import com.example.endo.adapters.AntonymsAdapter
import com.example.endo.adapters.AntonymsDialogAdapter
import com.example.endo.bottomsheetdialogs.AddAntonymsCategorySheetDialogFragment
import com.example.endo.databinding.FragmentAntonymsBinding
import com.example.endo.viewmodels.AntonymsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AntonymsFragment  :
    BaseFragment<FragmentAntonymsBinding>(FragmentAntonymsBinding::inflate),
    BaseAdapter.IBaseAdapterClickListener<AntonymsModel> {
    private val args: AntonymsFragmentArgs by navArgs()
    private val viewModel: AntonymsViewModel by viewModels()
    private val adapter = AntonymsAdapter()
    private val antonymsDialogAdapter= AntonymsDialogAdapter()
    private var categoryName = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeToolbarTitle()
    }

    private fun changeToolbarTitle() {
        (requireActivity() as MainActivity).binding.toolbarMain.title = categoryName
    }

    override fun initClickers() {
        binding.addAntonymsFab.setOnClickListener {
            CommonFunction.showBottomSheet(
                AddAntonymsCategorySheetDialogFragment(),
                requireActivity(),
                categoryName
            )
        }
    }


    override fun setArgsValue() {
        categoryName = args.antonymsCategoryModel.categoryName
    }

    override fun initAdapter() {
        binding.antonymsRecycler.adapter = adapter
        adapter.listener = this
    }

    override fun initObserver() {
        viewModel.getData(categoryName)
        viewModel.viewModelScope.launch {
            viewModel.antonymsModel.collect {
                if (it != null) {
                    adapter.setData(it)
                }
            }
        }
    }

    override fun onClick(model: AntonymsModel, position: Int) {
        val dialog = requireContext().getDialog(R.layout.antonyms_dialog)
        val antonymsWord = dialog.findViewById<TextView>(R.id.word)
        val closeBtn = dialog.findViewById<Button>(R.id.close_btn)
        val antonymsRecycler= dialog.findViewById<RecyclerView>(R.id.antonyms_recycler)

        antonymsWord.text = model.antonymsWord
        antonymsRecycler.adapter = antonymsDialogAdapter
        antonymsDialogAdapter.listener=this
        closeBtn.setOnClickListener { dialog.dismiss() }
        dialog.show()
    }
    }

