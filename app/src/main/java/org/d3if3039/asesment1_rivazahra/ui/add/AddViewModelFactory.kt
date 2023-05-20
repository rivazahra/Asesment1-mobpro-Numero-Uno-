package org.d3if3039.asesment1_rivazahra.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3039.asesment1_rivazahra.db.FoodDao

class AddViewModelFactory (private val db: FoodDao) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(MakananViewModel::class.java)){
            return MakananViewModel(db) as T
        }
        throw java.lang.IllegalArgumentException("Unknown Viewmodel class")
    }
}