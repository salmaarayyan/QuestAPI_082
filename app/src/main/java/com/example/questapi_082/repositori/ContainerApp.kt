package com.example.questapi_082.repositori

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

interface ContainerApp{
    val repositorySiswa: RepositoryDataSiswa
}

class DefaultContainerApp : ContainerApp{
    private val baseurl = "http://10.0.2.2/tiumy/"

    val logging = HttpLoggingInterceptor().apply {
        level= HttpLoggingInterceptor.Level.BODY

    }

    val klien = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(baseurl)
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            }.asConverterFactory("application/json".toMediaType())
        )
        .client(klien)
        .build()

}

