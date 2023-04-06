package com.example.home_edit_fragment_viewmodel_livedata.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.home_edit_fragment_viewmodel_livedata.viewModels.MainActivityViewModel

class MainActivityViewModelFactory(var firstName: String, var lastName: String, var email: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java)) {
            return MainActivityViewModel(firstName, lastName, email) as T
        }
        throw IllegalArgumentException("Unknown view model")
    }
}