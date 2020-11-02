package com.a.up.user.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.a.up.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        login_btn.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeHostFragment())
        }
        login_btn_2.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHiltTestFragment())
        }
    }

}






