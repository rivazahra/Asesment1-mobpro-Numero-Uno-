package org.d3if3039.asesment1_rivazahra.ui.histori

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3039.asesment1_rivazahra.db.FoodDao

class HistoriViewModel (private val db: FoodDao) : ViewModel() {

    val data = db.getLastFood()
    fun hapusData() = viewModelScope.launch {
        withContext(Dispatchers.IO){
            db.clearData()
        }
    }

}