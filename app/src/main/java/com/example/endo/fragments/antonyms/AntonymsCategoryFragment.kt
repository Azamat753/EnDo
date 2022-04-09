package com.example.endo.fragments.antonyms
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.core.base.BaseAdapter
import com.example.core.base.BaseFragment
import com.example.core.utils.CommonFunction.showBottomSheet
import com.example.db.models.AntonymsCategoryModel
import com.example.endo.adapters.AntonymsCategoryAdapter
import com.example.endo.bottomsheetdialogs.AddAntonymsCategorySheetDialogFragmentFragmentFragment
import com.example.endo.databinding.FragmentAntonymsCategoryBinding
import com.example.endo.viewmodels.SynonymsCategoryViewModel


class AntonymsCategoryFragment :
    BaseFragment<FragmentAntonymsCategoryBinding>
        (FragmentAntonymsCategoryBinding :: inflate) , BaseAdapter.IBaseAdapterClickListener<AntonymsCategoryModel>{

    private val adapter = AntonymsCategoryAdapter()
    private val viewModel : SynonymsCategoryViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initClickers()
    }
    override fun initAdapter() {
        adapter.listener = this
        binding.antonymsCategoryRecycler.adapter = adapter
    }
    override fun initObserver() {
    }

    override fun initClickers() {
        binding.addWordAntonyms.setOnClickListener {
            showBottomSheet(AddAntonymsCategorySheetDialogFragmentFragmentFragment(), requireActivity(), "")
        }
    }

    override fun onClick(model: AntonymsCategoryModel, position: Int) {

    }

}