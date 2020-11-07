package com.a.up.user.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.a.up.R
import com.a.up.user.data.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.*

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val homeViewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        login_btn.setOnClickListener {
            //            here should check for login response and if true save the token and then navigate
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeHostFragment())
        }
        login_btn_2.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHiltTestFragment())
        }
    }

}






