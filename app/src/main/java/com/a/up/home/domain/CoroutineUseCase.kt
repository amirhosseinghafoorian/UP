//package com.a.up.home.domain
//
//import com.a.up.core.resource.Resource
//import kotlinx.coroutines.CoroutineDispatcher
//import kotlinx.coroutines.withContext
//
//abstract class CoroutineUseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {
//    suspend operator fun invoke(parameters: P): Resource<R> {
//        return try {
//            withContext(coroutineDispatcher) {
//                execute(parameters).let {
//                    Resource.success(it)
//                }
//            }
//        } catch (e: Exception) {
//            Resource.error(e.message, null , -1)
//        }
//    }
//
//    @Throws(RuntimeException::class)
//    protected abstract suspend fun execute(parameters: P): R
//}