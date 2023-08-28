package com.diva.pimpaddokter.repository

import androidx.lifecycle.MutableLiveData
import com.diva.pimpaddokter.model.ResultDetectUser
import com.google.firebase.database.*

class ResultDetectUserRepository {

    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("ResultAcneForDokter")
    private var resultUserLists = ArrayList<ResultDetectUser>()

    @Volatile private var INSTANCE : ResultDetectUserRepository ?= null
    fun getInstance(): ResultDetectUserRepository{
        return INSTANCE ?: synchronized(this){
            val instance = ResultDetectUserRepository()
            INSTANCE = instance
            instance
        }
    }

    fun loadResultDetectPasien(resultDetectUserList: MutableLiveData<ArrayList<ResultDetectUser>>){
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                resultUserLists.clear()
                try {
                    val _resultDetectUserList : ArrayList<ResultDetectUser> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(ResultDetectUser::class.java)!!
                    } as ArrayList<ResultDetectUser>
                    resultDetectUserList.postValue(_resultDetectUserList)
                } catch (e : Exception){

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }
        })
    }
}