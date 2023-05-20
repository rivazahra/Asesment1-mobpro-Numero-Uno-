package org.d3if3039.asesment1_rivazahra.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3039.asesment1_rivazahra.db.FoodDao

class HistoriViewModelFactory(private val db: FoodDao):ViewModelProvider.Factory
{
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(HistoriViewModel::class.java)){
            return HistoriViewModel(db) as T
        }
        throw IllegalAccessException("Unknown ViewModel class")

    }

}