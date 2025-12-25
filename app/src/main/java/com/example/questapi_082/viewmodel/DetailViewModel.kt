package com.example.questapi_082.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.questapi_082.modeldata.DataSiswa
import com.example.questapi_082.repositori.RepositoryDataSiswa
import kotlinx.coroutines.launch
import kotlinx.serialization.InternalSerializationApi

@file:OptIn(InternalSerializationApi::class)

sealed interface StatusUIDetail {
    data class Success(val satusiswa: DataSiswa) : StatusUIDetail
    object Error : StatusUIDetail
    object Loading : StatusUIDetail
}
class DetailViewModel (savedStateHandle: SavedStateHandle, private val repositoryDataSiswa: RepositoryDataSiswa): ViewModel(){
    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetail.itemIdArg])
    var statusUIDetail: StatusUIDetail by mutableStateOf(StatusUIDetail.Loading)
        private set

    init {
        getSatuSiswa()
    }

    fun getSatuSiswa(){
        viewModelScope.launch {
            statusUIDetail = StatusUIDetail.Loading
            statusUIDetail = try {
                statusUIDetail.Success(satusiswa = repositoryDataSiswa.getSatuSiswa(idSiswa))
            }
            catch (e: Exception){
                statusUIDetail.Error
            }
            catch (e: Exception){
                statusUIDetail.Error
            }
        }
    }
}