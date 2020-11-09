package com.a.up.general

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.a.up.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val navControler = findNavController(R.id.host_fragment)
//        navControler.graph
    }
}