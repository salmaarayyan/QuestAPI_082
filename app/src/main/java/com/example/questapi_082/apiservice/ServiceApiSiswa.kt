package com.example.questapi_082.apiservice

import com.example.questapi_082.modeldata.DataSiswa

interface ServiceApiSiswa{
    @GET("bacaTeman.php")
    suspend fun getSiswa(): List<DataSiswa>


}