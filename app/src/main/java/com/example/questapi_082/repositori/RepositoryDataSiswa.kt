package com.example.questapi_082.repositori

import com.example.questapi_082.modeldata.DataSiswa

interface RepositoryDataSiswa{
    suspend fun getDataSiswa(): List<DataSiswa>
    suspend fun postDataSiswa(dataSiswa: DataSiswa) :retrofit2.Response<Void>
}

