package com.peterkrauz.grimoire.presentation.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.peterkrauz.grimoire.common.extension.safeNavigate
import com.peterkrauz.grimoire.common.extension.snackBar
import com.peterkrauz.grimoire.common.snackbar.SnackBarType
import com.peterkrauz.grimoire.domain.entity.Arc
import com.peterkrauz.grimoire.presentation.home.arclist.ArcSwipeCallback
import com.peterkrauz.grimoire.presentation.home.arclist.ArcsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_arcs.*

@AndroidEntryPoint
class ArcsFragment : Fragment(R.layout.fragment_arcs) {

    private val viewModel by viewModels<ArcsViewModel>()

    private val arcsAdapter by lazy(::ArcsAdapter)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupButtons()
        setupRecyclerView()
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadArcs()
    }

    private fun setupButtons() {
        floatingActionButton.setOnClickListener {
            safeNavigate(R.id.arcsFragment, R.id.createArcAction)
        }
    }

    private fun setupRecyclerView() {
        recyclerViewArcs.apply {
            setHasFixedSize(true)
            adapter = arcsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }.also { recyclerView ->
            ItemTouchHelper(
                ArcSwipeCallback(::onSwiped)
            ).attachToRecyclerView(recyclerView)
        }
    }

    private fun observeViewModel() {
        viewModel.arcsLiveData.observe(viewLifecycleOwner, ::setArcs)
        viewModel.stateLiveData.observe(viewLifecycleOwner, ::setState)
        viewModel.errorLiveEvent.observe(viewLifecycleOwner) { setError() }
        viewModel.arcDeletedLiveEvent.observe(viewLifecycleOwner) { onArcDeleted() }
    }

    private fun setArcs(arcs: List<Arc>) {
        arcsAdapter.submitList(arcs)
        recyclerViewArcs.isVisible = arcs.isNotEmpty()
        linearLayoutEmptyState.isVisible = arcs.isEmpty()
    }

    private fun setState(state: ArcsState) {
        progressBarState.isVisible = state == ArcsState.LOADING
    }

    private fun setError() = snackBar(R.string.generic_error_msg, SnackBarType.ERROR)

    private fun onArcDeleted() = snackBar(R.string.arc_delete_success)

    private fun onSwiped(position: Int) {
        val arc = arcsAdapter.getItemAt(position)
        viewModel.onSwiped(arc)
    }
}
