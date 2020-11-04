package com.a.up.home.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.a.up.R
import com.a.up.listItem
import kotlinx.android.synthetic.main.fragment_home1.*

class HomeFragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fillRecycler()
    }

    private fun fillRecycler() {
        val items = mutableListOf<String>()
        repeat(100) {
            items.add("user ")
        }

        recyclerView.withModels {
            items.forEachIndexed { pos, model ->
                listItem {
                    id(pos)
                    username(model + pos.toString())
                }
            }
        }
    }

}