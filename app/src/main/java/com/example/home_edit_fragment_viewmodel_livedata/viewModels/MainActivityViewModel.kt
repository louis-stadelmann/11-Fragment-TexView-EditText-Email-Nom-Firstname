package com.example.home_edit_fragment_viewmodel_livedata.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(firstName: String, lastName: String, email: String) : ViewModel() {
    val firstName = MutableLiveData(firstName)
    val lastName = MutableLiveData(lastName)
    val email = MutableLiveData(email)

    fun setFirstName(value: String) {
        firstName.value = value
    }
    fun setLastName(value: String) {
        lastName.value = value
    }
    fun setEmail(value: String) {
        email.value = value
    }
}