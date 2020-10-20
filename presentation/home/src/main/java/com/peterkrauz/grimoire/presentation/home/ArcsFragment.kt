package com.peterkrauz.grimoire.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_arcs.*

@AndroidEntryPoint
class ArcsFragment : Fragment(R.layout.fragment_arcs) {

    private val viewModel: ArcsViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
        observeViewModel()
    }

    private fun setupButtons() {
        floatingActionButton.setOnClickListener {
            findNavController().navigate(R.id.createArcAction)
        }
    }

    private fun observeViewModel() {
    }
}
