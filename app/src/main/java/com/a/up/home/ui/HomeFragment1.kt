package com.a.up.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DiffUtil
import com.a.up.R
import com.a.up.home.data.HomeViewModel
import com.a.up.user.model.Data
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home1.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class HomeFragment1 : Fragment() {

    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var usersListAdapter: UsersListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpAdapter()

        viewLifecycleOwner.lifecycleScope.launch {
            homeViewModel.pagedUsers().collect { users ->
                usersListAdapter.submitData(users)
            }
        }

//        homeViewModel.userList.observe(viewLifecycleOwner, { list ->
//            if (list != null) {
//                fillRecycler(list)
//            }
//        })

//        CoroutineScope(Dispatchers.IO).launch {
//            homeViewModel.fillFromViewModel(2)
//        }
    }

    object UserComparator : DiffUtil.ItemCallback<Data>() {
        override fun areItemsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Data, newItem: Data): Boolean {
            return oldItem == newItem
        }
    }

    private fun setUpAdapter() {
        usersListAdapter = UsersListAdapter(UserComparator)

        recyclerView.apply {
            adapter = usersListAdapter
        }
    }
}

/*
// ------------------------------------------------------------------------------

//                  ***          removed epoxy          ***

//        recyclerView.withModels {
//            items.forEachIndexed { pos, model ->
//                listItem {
//                    id(pos)
//                    username(model)
////                    onClickListItem{ _ ->
////                        Log.i("baby" , "$model : $pos")
////                    }
//                }
//            }
//        }
//                  ***          removed epoxy          ***

 */