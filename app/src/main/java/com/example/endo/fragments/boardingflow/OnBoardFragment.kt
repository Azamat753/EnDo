package com.example.endo.fragments.boardingflow

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.core.utils.CacheManager
import com.example.core.base.BaseFragment
import com.example.endo.R
import com.example.endo.databinding.FragmentOnBoardBinding
import com.example.endo.models.BoardModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class OnBoardFragment : BaseFragment<FragmentOnBoardBinding>(FragmentOnBoardBinding::inflate),
    PagerListener {
    val adapter = ViewPagerAdapter(this)

    @Inject
    lateinit var cacheManager: CacheManager

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun initAdapter() {
        binding.pager.adapter = adapter
        adapter.setData(getBoardList())
        binding.dotsIndicator.setViewPager2(binding.pager)
    }

    override fun initClickers() {

    }

    private fun getBoardList(): ArrayList<BoardModel> {
        val list: ArrayList<BoardModel> = arrayListOf()
        list.add(
            BoardModel(
                "music.json",
                "Аудирование",
                "Учим английский прослушивая отрывки из книг,фильмов и песен"
            )
        )
        list.add(
            BoardModel(
                "grammar.json", "Грамматика", "Учимся разговоривать на практике " +
                        "через переписки и аудиозвонки"
            )
        )
        list.add(
            BoardModel(
                "speaking.json",
                "Разговорный",
                "Учим английский прослушивая отрывки из книг,фильмов и песен"
            )
        )
        list.add(BoardModel("launch.json", "Давайте начнём !", ""))
        return list
    }

    override fun onStartClick() {
        cacheManager.setBoardShowed()
        findNavController().popBackStack(R.id.splashFragment,true)
        findNavController().navigate(R.id.todayFragment)
    }

    override fun initObserver() {

    }


}