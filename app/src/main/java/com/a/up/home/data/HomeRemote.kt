package com.a.up.home.data

import android.util.Log
import javax.inject.Inject

class HomeRemote @Inject
constructor(private val retrofit : String)
{

   fun fillFromRemote(){
       Log.i("nmudi", retrofit)
   }

}