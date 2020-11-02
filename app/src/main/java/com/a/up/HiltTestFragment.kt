package com.a.up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HiltTestFragment : Fragment() {

    //      field injection
    @Inject
    lateinit var someClass: SomeClass

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hilt_test, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        println(someClass.doAThing())
        println(someClass.doSomeOtherThing())

    }
}

class SomeClass
@Inject
constructor(
    //      constructor injection
    private val someOtherClass: SomeOtherClass
) {
    fun doAThing(): String {
        return "Look I did a thing !"
    }

    fun doSomeOtherThing(): String {
        return someOtherClass.doSomeOtherThing()
    }
}

class SomeOtherClass
@Inject
constructor() {
    fun doSomeOtherThing(): String {
        return "I did another thing baby!"
    }
}