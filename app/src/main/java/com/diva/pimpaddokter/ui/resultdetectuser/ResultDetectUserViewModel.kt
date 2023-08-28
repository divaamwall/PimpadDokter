package com.diva.pimpaddokter.ui.resultdetectuser

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diva.pimpaddokter.model.ResultDetectUser
import com.diva.pimpaddokter.repository.ResultDetectUserRepository

class ResultDetectUserViewModel : ViewModel() {
    private val repository: ResultDetectUserRepository
    val allResultDetectUser = MutableLiveData<ArrayList<ResultDetectUser>>()

    init {
        repository = ResultDetectUserRepository().getInstance()
        repository.loadResultDetectPasien(allResultDetectUser)
    }
}