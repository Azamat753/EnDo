package com.example.endo.fragments.splashflow

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.core.utils.CacheManager
import com.example.core.base.BaseFragment
import com.example.core.extensions.launchWhenStarted
import com.example.endo.R
import com.example.endo.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {
    @Inject
    lateinit var cacheManager: CacheManager

    private val viewModel: SplashViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        checkIsShow()
    }

    private fun checkIsShow() {
        viewModel.isSplashFinished.onEach {
            if (it) {
                if (cacheManager.isShow) {
                    findNavController().navigate(R.id.todayFragment)
                } else {
                    findNavController().navigate(R.id.onBoardFragment)
                }
            }
        }.launchWhenStarted(lifecycleScope)
    }

    override fun initClickers() {

    }

    override fun initObserver() {


    }
}