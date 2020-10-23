package com.peterkrauz.grimoire.presentation.home.create

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.peterkrauz.grimoire.common.MainViewModel
import com.peterkrauz.grimoire.common.extension.snackBar
import com.peterkrauz.grimoire.common.snackbar.SnackBarType
import com.peterkrauz.grimoire.presentation.home.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_create_arc.*

@AndroidEntryPoint
class CreateArcFragment : Fragment(R.layout.fragment_create_arc) {

    private val viewModel by viewModels<CreateArcViewModel>()
    private val mainViewModel by viewModels<MainViewModel>(::requireActivity)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        observeViewModel()
    }

    private fun setupView() {
        setupToolbar()
        setupButton()
        setupTextInputs()
    }

    private fun setupToolbar() {
        toolbar.run {
            setTitle(R.string.create_arc)
            setNavigationOnClickListener { findNavController().navigateUp() }
        }
    }

    private fun setupButton() {
        buttonCreate.setOnClickListener {
            viewModel.onCreateClicked()
        }
    }

    private fun setupTextInputs() {
        editTextTitle.addTextChangedListener { viewModel.onTitleChanged(it.toString()) }
        editTextDescription.addTextChangedListener { viewModel.onDescriptionChanged(it.toString()) }
    }

    private fun observeViewModel() {
        viewModel.stateLiveData.observe(viewLifecycleOwner, ::setState)
        viewModel.errorLiveEvent.observe(viewLifecycleOwner) { showErrorSnackBar() }
    }

    private fun setState(state: CreateArcState) {
        progressBarState.isVisible = state == CreateArcState.CREATING
        editTextTitle.isEnabled = state != CreateArcState.CREATING
        editTextDescription.isEnabled = state != CreateArcState.CREATING
        buttonCreate.isEnabled = state == CreateArcState.READY

        if (state == CreateArcState.FINISHED) {
            mainViewModel.onArcCreated()
            findNavController().navigateUp()
        }
    }

    private fun showErrorSnackBar() {
        snackBar(R.string.generic_error_msg, SnackBarType.ERROR)
    }
}
