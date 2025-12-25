package com.example.questapi_082.uicontroller.route

import com.example.questapi_082.R

object DestinasiDetail : DestinasiNavigasi {
    override val route = "detail"
    override val titleRes = R.string.detail_siswa
    const val itemIdArg = "id"
    val routeWithArgs = "$route/{IdArgs}"
}
