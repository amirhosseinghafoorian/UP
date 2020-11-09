package com.a.up.user.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.a.up.R
import com.a.up.core.resource.Status
import com.a.up.general.GeneralKeys
import com.a.up.user.data.UserViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val userViewModel: UserViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        userViewModel.loginResult.observe(viewLifecycleOwner, { result ->
            if (result != null) {
                if (result.status == Status.SUCCESS || result.code == 200) {
                    CoroutineScope(Dispatchers.IO).launch {
                        userViewModel.putPrefString(
                            GeneralKeys.pref_key_token,
                            result.data?.token.toString()
                        )
                        withContext(Dispatchers.Main) {
                            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHomeHostFragment())
                        }
                    }
                } else if (result.status == Status.LOADING) {
                    Toast.makeText(requireContext(), GeneralKeys.key_wait, Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(
                        requireContext(),
                        GeneralKeys.key_wrong_user_pass,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        })

        login_btn.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                userViewModel.login(
                    login_et_1.editText?.text.toString(),
                    login_et_2.editText?.text.toString()
                )
            }
        }
        login_btn_2.setOnClickListener {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToHiltTestFragment())
        }
    }

}






