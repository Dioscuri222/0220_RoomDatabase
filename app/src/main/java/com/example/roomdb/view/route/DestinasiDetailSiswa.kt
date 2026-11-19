package com.example.roomdb.view.route

import com.example.roomdb.uicontroller.DestinasiNavigasi

object DestinasiDetailSiswa : DestinasiNavigasi {
    override val route = "detail_siswa"

    override val titleRes = "Detail Siswa"

    const val itemIArg = "idSiswa"

    val routeWithArgs = "$route/{$itemIArg}"
}