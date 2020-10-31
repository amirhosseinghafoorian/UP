package com.a.up.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.a.up.R
import com.a.up.setupWithNavController
import kotlinx.android.synthetic.main.fragment_home_host.*

class HomeHostFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home_host, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val navHostFragment = NavHostFragment.create(R.navigation.home_nav_graph_1)
//        val transaction = childFragmentManager.beginTransaction()
//        transaction.add(R.id.fragment,navHostFragment)
//        transaction.commitNow()
//        bottom_nav.setupWithNavController(navHostFragment.findNavController())

        val navGraphIds = listOf(
            R.navigation.home_nav_graph_1,
            R.navigation.home_nav_graph_2,
            R.navigation.home_nav_graph_3
        )

        bottom_nav.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = childFragmentManager,
            containerId = R.id.fragment,
            intent = requireActivity().intent
        )
    }
}