package com.a.up.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.a.up.R
import com.a.up.home.data.HomeViewModel
import com.a.up.listItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home1.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment1 : Fragment() {
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel.userList.observe(viewLifecycleOwner, { list ->
            if (list != null) {
                fillRecycler(list)
            }
        })

        CoroutineScope(Dispatchers.IO).launch {
            homeViewModel.fillFromViewModel(2)
        }
    }

    private fun fillRecycler(items: MutableList<String>) {

        recyclerView.withModels {
            items.forEachIndexed { pos, model ->
                listItem {
                    id(pos)
                    username(model)
//                    onClickListItem{ _ ->
//                        Log.i("baby" , "$model : $pos")
//                    }
                }
            }
        }
    }

}