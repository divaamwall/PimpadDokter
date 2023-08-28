package com.diva.pimpaddokter.ui.listchat

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.diva.pimpaddokter.model.Users
import com.diva.pimpaddokter.repository.UserRepository

class ChatViewModel : ViewModel() {

    private val repository : UserRepository
    val allUsers = MutableLiveData<ArrayList<Users>>()

    init {
        repository = UserRepository().getInstance()
        repository.loadUsers(allUsers)
    }
}