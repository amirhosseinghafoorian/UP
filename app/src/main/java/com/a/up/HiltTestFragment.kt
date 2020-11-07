package com.a.up

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton
//
//@AndroidEntryPoint
class HiltTestFragment : Fragment() {
//
//    //      field injection
//    @Inject
//    lateinit var someClass: SomeClass
//
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hilt_test, container, false)
    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
////        println(someClass.doAThing1())
////        println(someClass.doAThing2())
//
//    }
}
//
//class SomeClass
//@Inject
//constructor(
//    //      constructor injection
////    @Impl1 private val someInterfaceImpl1: SomeInterface,
////    @Impl2 private val someInterfaceImpl2: SomeInterface
//) {
////    fun doAThing1(): String {
////        return "Look I did ${someInterfaceImpl1.getAThing()}"
////    }
////
////    fun doAThing2(): String {
////        return "Look I did ${someInterfaceImpl2.getAThing()}"
////    }
//}
//
//class SomeInterfaceImpl1
//@Inject
//constructor(
//    private val someDependency: String
//) : SomeInterface {
//    override fun getAThing(): String {
//        return "A thing1, $someDependency"
//    }
//}
//
//class SomeInterfaceImpl2
//@Inject
//constructor(
//    private val someDependency: String
//) : SomeInterface {
//    override fun getAThing(): String {
//        return "A thing2, $someDependency"
//    }
//}
//
//interface SomeInterface {
//    fun getAThing(): String
//}
//
//@InstallIn(ApplicationComponent::class)
//@Module
//class MyModule {
//
//    @Singleton
//    @Provides
//    fun sj(): String {
//        return "some string"
//    }
//
////    @Singleton
////    @Provides
////    fun provideSomeString(): String {
////        return "some string"
////    }
////
////    @Impl1
////    @Singleton
////    @Provides
////    fun provideSomeInterface1(
////        someString: String
////    ): SomeInterface {
////        return SomeInterfaceImpl1(someString)
////    }
////
////    @Impl2
////    @Singleton
////    @Provides
////    fun provideSomeInterface2(
////        someString: String
////    ): SomeInterface {
////        return SomeInterfaceImpl2(someString)
////    }
//
//
//}
////
////@Qualifier
////@Retention(AnnotationRetention.BINARY)
////annotation class Impl1
////
////@Qualifier
////@Retention(AnnotationRetention.BINARY)
////annotation class Impl2