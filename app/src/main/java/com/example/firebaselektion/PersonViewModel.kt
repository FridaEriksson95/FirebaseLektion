package com.example.firebaselektion

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

//Slussar vidare information från firebaseManager till MainActivity
class PersonViewModel : ViewModel() {
    val firebaseManager = FirebaseManager()

    val persons : LiveData<MutableList<Person>> get() = firebaseManager.persons

    fun addPerson(name: String, phone: String) {
        firebaseManager.addPerson(name, phone)
    }
}