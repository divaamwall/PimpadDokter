package com.diva.pimpaddokter.repository

import androidx.lifecycle.MutableLiveData
import com.diva.pimpaddokter.model.Users
import com.google.firebase.database.*

class UserRepository {
    private val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().getReference("Users")
    private var userlist = ArrayList<Users>()

    @Volatile private var INSTANCE : UserRepository ?= null
    fun getInstance(): UserRepository{
        return INSTANCE ?: synchronized(this){

            val instance = UserRepository()
            INSTANCE = instance
            instance
        }
    }


    fun loadUsers(userList : MutableLiveData<ArrayList<Users>>,){
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                userlist.clear()
                try {
                    val _userList : ArrayList<Users> = snapshot.children.map { dataSnapshot ->
                        dataSnapshot.getValue(Users::class.java)!!
                    } as ArrayList<Users>
                    userList.postValue(_userList)

                }catch (e: Exception){

                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}