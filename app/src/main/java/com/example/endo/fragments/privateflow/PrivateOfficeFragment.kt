package com.example.endo.fragments.privateflow

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import coil.load
import com.example.core.utils.CacheManager
import com.example.core.base.BaseFragment
import com.example.db.models.AchievementsModel
import com.example.endo.R
import com.example.endo.adapters.AchievementAdapter
import com.example.endo.databinding.FragmentPrivateOfficeBinding
import com.example.endo.viewmodels.WordsViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class PrivateOfficeFragment :
    BaseFragment<FragmentPrivateOfficeBinding>(FragmentPrivateOfficeBinding::inflate) {
    private val adapter = AchievementAdapter()
    private val viewModel: WordsViewModel by viewModels()

    @Inject
    lateinit var cacheManager: CacheManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onResume() {
        super.onResume()
        checkImage()
    }

    private fun checkImage() {
        val image = cacheManager.userImage
        if (image.isNotEmpty()) {
            binding.userImage.load(image)
        } else {
            binding.userImage.load(R.drawable.ic_app_icon_foreground)
        }
    }

    override fun initClickers() {
        binding.userImage.setOnClickListener {
            getContent.launch("image/*")
        }
    }

    private val getContent =
        registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
            val image = uri.toString()
            if (image.isNotEmpty()) {
                binding.userImage.load(image)
                cacheManager.saveUserImage(image)
            }
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

    override fun initObserver() {


    }
}