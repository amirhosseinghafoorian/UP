package com.a.up.home.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.a.up.R
import com.a.up.home.data.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment
    : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onStart() {
        super.onStart()

        val handler = Handler()
        handler.postDelayed({
            val pref = homeViewModel.getPrefString("javad")
            if (pref == "***") {
                homeViewModel.putPrefString("javad", "baby")
            }
            Toast.makeText(requireContext(), pref, Toast.LENGTH_SHORT)
                .show()
//                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
        }, 3000)
    }

}