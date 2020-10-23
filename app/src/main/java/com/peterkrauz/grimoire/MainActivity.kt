package com.peterkrauz.grimoire

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.peterkrauz.grimoire.common.MainViewModel
import com.peterkrauz.grimoire.common.extension.snackBar
import com.peterkrauz.grimoire.common.snackbar.SnackBarType
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val mainViewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Grimoire)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupView()
        observeViewModel()
    }

    private fun setupView() {
        bottomNavigationView.run {
            setOnNavigationItemReselectedListener { Unit }
            setupWithNavController(mainNavFragment.findNavController())
        }
    }

    private fun observeViewModel() {
        mainViewModel.arcCreatedLiveEvent.observe(this) { showArcCreatedSnackBar() }
    }

    private fun showArcCreatedSnackBar() {
        snackBar(rootLayout, R.string.arc_created_success, SnackBarType.SUCCESS)
    }
}