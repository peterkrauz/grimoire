package com.peterkrauz.grimoire.presentation.home.arcdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.transition.MaterialContainerTransform
import com.peterkrauz.grimoire.domain.entity.arc.Arc
import com.peterkrauz.grimoire.presentation.home.R
import com.peterkrauz.grimoire.presentation.home.eventlist.EventsAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_arc_detail.*

@AndroidEntryPoint
class ArcDetailFragment : Fragment(R.layout.fragment_arc_detail) {

    private val args by navArgs<ArcDetailFragmentArgs>()

    private val arcId get() = args.arcId

    private val viewModel by viewModels<ArcDetailViewModel>()

    private val eventsAdapter by lazy { EventsAdapter(viewModel::onEventClick) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        configureSharedElementReturnTransition()
        super.onViewCreated(view, savedInstanceState)
        setupView()
        observeViewModel()
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadArc()
    }

    private fun configureSharedElementReturnTransition() {
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = 500L
            isElevationShadowEnabled = true
        }
    }

    private fun setupView() {
        constraintLayoutArcDetail.transitionName = "arc_$arcId"
        toolbar.setNavigationOnClickListener { findNavController().navigateUp() }
        recyclerViewEvents.adapter = eventsAdapter
        recyclerViewEvents.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun observeViewModel() {
        viewModel.arcLiveData.observe(viewLifecycleOwner, ::setArc)
    }

    private fun setArc(arc: Arc) {
        collapsingToolbar.title = arc.title
        eventsAdapter.addArcDescription(arc.description)
    }
}
