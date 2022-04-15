package com.example.endo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.core.extensions.gone
import com.example.core.extensions.visible
import com.example.endo.R
import com.example.endo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
     lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupWindowBackgroundColor()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initBottomNavigation()
        setupNavigation()
        changeTitleToolbar()
    }

    private fun setupWindowBackgroundColor() {
        window.setBackgroundDrawableResource(R.color.white)
    }

    private fun initBottomNavigation() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        binding.bottomNavigation.itemIconTintList = null
        binding.bottomNavigation.setupWithNavController(navController)
    }

    private fun changeTitleToolbar() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.todayFragment -> {
                    binding.toolbarMain.title = getString(R.string.today)
                }
                R.id.learnFragment -> {
                    binding.toolbarMain.title = getString(R.string.learn)
                }
                R.id.dictionaryFragment -> {
                    binding.toolbarMain.title = getString(R.string.dictionary_learn)
                }
                R.id.myDictionaryFragment -> {
                    binding.toolbarMain.title = getString(R.string.my_dictionary)
                }
                R.id.dictionaryCategoryFragment -> {
                    binding.toolbarMain.title = getString(R.string.categories)
                }
                R.id.privateOfficeFragment -> {
                    binding.toolbarMain.title = getString(R.string.private_office)
                }
                R.id.colloquialFragment -> {
                    binding.toolbarMain.title = getString(R.string.speaking_learn)
                }
                R.id.pronunciationFragment -> {
                    binding.toolbarMain.title = getString(R.string.pronunciation)
                }
            }
        }
    }

    private fun setupNavigation() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in arrayOf(
                    R.id.splashFragment,
                    R.id.onBoardFragment
                )
            ) {
                binding.toolbarMain.gone()
                binding.bottomNavigation.gone()
            } else {
                binding.toolbarMain.visible()
                binding.bottomNavigation.visible()
            }
//            if (destination.id in arrayOf(
//                )
//            ) {
//                binding.bottomNavigation.gone()
//            }
        }
    }
}