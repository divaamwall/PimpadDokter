package com.diva.pimpaddokter.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diva.pimpaddokter.model.Acne
import com.diva.pimpaddokter.repository.AcneRepository

class HomeViewModel : ViewModel() {

    private val repository : AcneRepository
    val allAcnes = MutableLiveData<ArrayList<Acne>>()

    init {
        repository = AcneRepository().getInstance()
        repository.loadAcnes(allAcnes)
    }
}