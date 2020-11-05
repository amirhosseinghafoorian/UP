package com.a.up.home.ui

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.a.up.R
import com.a.up.storage.Setting

class SplashFragment
//@Inject constructor(private val setting: Setting)
    : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.KITKAT) {
//            activity?.window?.decorView?.systemUiVisibility =
//                (View.SYSTEM_UI_FLAG_IMMERSIVE or View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
//                        or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or View.SYSTEM_UI_FLAG_FULLSCREEN)
//        }
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onStart() {
        super.onStart()

        //                                  *** EDIT ***
        val setting = Setting()
        val handler = Handler()
        handler.postDelayed({
            if (true) {
                if (setting.getString("javad") == "***") {
                    setting.putString("javad", "baby")
                }
                Toast.makeText(requireContext(), setting.getString("javad"), Toast.LENGTH_SHORT)
                    .show()
            } else {
                findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToLoginFragment())
            }
        //                                  *** EDIT ***
        }, 3000)
    }

}