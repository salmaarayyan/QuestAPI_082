package com.example.questapi_082.viewmodel

import com.example.questapi_082.modeldata.DataSiswa
import kotlinx.serialization.InternalSerializationApi

@file:OptIn(InternalSerializationApi::class)

sealed interface StatusUIDetail {
    data class Success(val satusiswa: DataSiswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}