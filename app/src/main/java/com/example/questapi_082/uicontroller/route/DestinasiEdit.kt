package com.example.questapi_082.uicontroller.route

import com.example.questapi_082.R

object DestinasiEdit : DestinasiNavigasi {
    override val route = "edit"
    override val titleRes = R.string.edit_siswa
    const val itemIdArg = "id"
    val routeWithArgs = "${DestinasiDetail.route}/{IdArgs}"
}
