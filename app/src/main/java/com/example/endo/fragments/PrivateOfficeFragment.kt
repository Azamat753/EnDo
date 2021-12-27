package com.example.endo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.core.base.BaseFragment
import com.example.db.models.AchievementsModel
import com.example.endo.R
import com.example.endo.adapters.AchievementAdapter
import com.example.endo.databinding.FragmentPrivateOfficeBinding
import com.example.endo.models.CategoryModel
import com.example.endo.viewmodels.WordsViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.ArrayList

@AndroidEntryPoint
class PrivateOfficeFragment :
    BaseFragment<FragmentPrivateOfficeBinding>(FragmentPrivateOfficeBinding::inflate) {
    private val adapter = AchievementAdapter()
    private val viewModel: WordsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initClickers() {

    }

    override fun initAdapter() {
        binding.achievementsRecycler.adapter = adapter
        adapter.setData(getAchievements())
    }

    private fun getAchievements(): List<AchievementsModel> {
        val list: ArrayList<AchievementsModel> = arrayListOf()
        list.add(
            AchievementsModel(
                rank = "Энтузиаст",
                condition = "Зайдите в приложение\n" +
                        "3 дня подряд",
                currentAmountForProgressBar = 1,
                maxAmountForProgressBar = 3,
                image = "https://i.pinimg.com/564x/a2/c3/67/a2c367398dd8c9fe5005d1e80389245c.jpg"
            )
        )
        list.add(
            AchievementsModel(
                rank = "Энтузиаст",
                condition = "Зайдите в приложение\n" +
                        "3 дня подряд",
                currentAmountForProgressBar = 1,
                maxAmountForProgressBar = 3,
                image = "https://i.pinimg.com/564x/a2/c3/67/a2c367398dd8c9fe5005d1e80389245c.jpg"
            )
        )
        list.add(
            AchievementsModel(
                rank = "Энтузиаст",
                condition = "Зайдите в приложение\n" +
                        "3 дня подряд",
                currentAmountForProgressBar = 1,
                maxAmountForProgressBar = 3,
                image = "https://i.pinimg.com/564x/a2/c3/67/a2c367398dd8c9fe5005d1e80389245c.jpg"
            )
        )
        return list
    }
}