package com.peterkrauz.grimoire.presentation.home.arcdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import com.peterkrauz.grimoire.domain.entity.Arc
import com.peterkrauz.grimoire.presentation.home.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_arc_detail.*

@AndroidEntryPoint
class ArcDetailFragment : Fragment(R.layout.fragment_arc_detail) {

    private val args by navArgs<ArcDetailFragmentArgs>()

    private val arcId get() = args.arcId

    private val viewModel by viewModels<ArcDetailViewModel>()

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
    }

    private fun observeViewModel() {
        viewModel.arcLiveData.observe(viewLifecycleOwner, ::setArc)
    }

    private fun setArc(arc: Arc) {
        collapsingToolbar.title = arc.title
    }
}
