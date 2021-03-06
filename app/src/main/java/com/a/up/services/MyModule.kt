package com.a.up.services

import android.content.Context
import com.a.up.general.MyApp
import com.a.up.storage.Setting
import com.a.up.storage.SettingDataStore
import com.facebook.flipper.plugins.network.FlipperOkhttpInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
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
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(MoshiConverterFactory.create())
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun api(retrofit: Retrofit) : Api {
        return retrofit.create(Api::class.java)
    }

    @Singleton
    @Provides
    fun provideSetting() : Setting {
        return Setting()
    }

    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext context: Context) : SettingDataStore {
        return SettingDataStore(context)
    }
}