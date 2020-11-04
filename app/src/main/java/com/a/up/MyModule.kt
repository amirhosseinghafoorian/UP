package com.a.up

import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object MyModule {

    @Singleton
    @Provides
    fun retro(): String {
        return "some string"
    }

    @Singleton
    @Provides
    fun client(): OkHttpClient {
        return OkHttpClient.Builder()
            .addNetworkInterceptor(FlipperOkhttpInterceptor(MyApp.networkFlipperPlugin))
            .addInterceptor { chain ->
                var newBuilder = chain.request().newBuilder()
                val request = newBuilder.build()
                chain.proceed(request)

            }
            .build()
    }

    @Singleton
    @Provides
    fun retrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://192.168.5.69:3000/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
    }
}