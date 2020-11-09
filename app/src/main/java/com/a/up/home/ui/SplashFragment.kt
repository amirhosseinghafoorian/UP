package com.a.up.home.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.a.up.R
import com.a.up.general.GeneralKeys
import com.a.up.home.data.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val handler = Handler()
        handler.postDelayed({

            lifecycleScope.launch(Dispatchers.Main) {

                val flow = homeViewModel.getPrefString(GeneralKeys.pref_key_token)
                flow.collect { value ->
                    if (value == GeneralKeys.pref_key_not_exist) {
                        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
                    } else {
                        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeHostFragment())
                    }
                    Toast.makeText(requireContext(), value, Toast.LENGTH_SHORT)
                        .show()
                }
            }

        }, 2000)
    }
}

