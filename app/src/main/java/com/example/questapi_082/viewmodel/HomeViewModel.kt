package com.example.questapi_082.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.questapi_082.modeldata.DataSiswa
import com.example.questapi_082.repositori.RepositoryDataSiswa

sealed interface StatusUiSiswa{
    data class Success(val siswa: List<DataSiswa>) : StatusUiSiswa
    object Error : StatusUiSiswa
    object Loading : StatusUiSiswa
}

class HomeViewModel(private val repositorySiswa: RepositoryDataSiswa) : ViewModel() {
    var listSiswa: StatusUiSiswa by mutableStateOf(StatusUiSiswa.Loading)
        private set

    init{
        loadSiswa()
    }
}