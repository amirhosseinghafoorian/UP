package com.a.up.home.ui

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.a.up.R
import com.a.up.home.data.HomeViewModel
import com.a.up.home.domain.AllUsersUseCase
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

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
            val pref = homeViewModel.getPrefString("token")
            if (pref == "***") {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
            } else {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeHostFragment())
            }
            Toast.makeText(requireContext(), pref, Toast.LENGTH_SHORT)
                .show()
        }, 3000)
    }

}