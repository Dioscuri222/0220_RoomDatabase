package com.example.roomdb.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roomdb.repositori.RepositoriSiswa
import com.example.roomdb.view.route.DestinasiDetailSiswa
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class EditViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriSiswa: RepositoriSiswa): ViewModel() {

    var uistateSiswa by mutableStateOf(UIStateSiswa())
        private set

    private val idSiswa: Int = checkNotNull(savedStateHandle[DestinasiDetailSiswa.itemIdArg])

    init {
        viewModelScope.launch {
            uistateSiswa = repositoriSiswa.getSiswaStream(idSiswa)
                .filterNotNull()
                .first()
                .toUIStateSiswa(true)
        }
    }
}