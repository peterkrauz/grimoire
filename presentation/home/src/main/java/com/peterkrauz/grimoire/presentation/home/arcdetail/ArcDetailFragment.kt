package com.peterkrauz.grimoire.presentation.home.arcdetail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.transition.MaterialContainerTransform
import com.peterkrauz.grimoire.presentation.home.R
import kotlinx.android.synthetic.main.fragment_arc_detail.*

class ArcDetailFragment : Fragment(R.layout.fragment_arc_detail) {

    private val args by navArgs<ArcDetailFragmentArgs>()

    private val arcId get() = args.arcId

    private val arcTransitionName get() = args.arcTransitionName

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        constraintLayoutArcDetail.transitionName = arcTransitionName
        sharedElementEnterTransition = MaterialContainerTransform().apply {
            duration = 500L
            isElevationShadowEnabled = true
        }
    }
}
