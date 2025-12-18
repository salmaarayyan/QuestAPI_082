package com.example.questapi_082.viewmodel

import com.example.questapi_082.modeldata.DataSiswa

sealed interface StatusUiSiswa{
    data class Success(val siswa: List<DataSiswa>) : StatusUiSiswa
    object Error : StatusUiSiswa
    object Loading : StatusUiSiswa
}