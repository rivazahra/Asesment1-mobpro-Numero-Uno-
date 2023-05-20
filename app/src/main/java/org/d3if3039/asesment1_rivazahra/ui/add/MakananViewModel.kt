package org.d3if3039.asesment1_rivazahra.ui.add

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3039.asesment1_rivazahra.db.FoodDao
import org.d3if3039.asesment1_rivazahra.db.FoodEntity
import org.d3if3039.asesment1_rivazahra.model.Food
import org.d3if3039.asesment1_rivazahra.model.saveData

class MakananViewModel(private val db: FoodDao) : ViewModel() {
    private val hasilMakanan = MutableLiveData<Food>()


    val data = db.getLastFood()

    fun saveData(nama: String, deskripsi: String) {
        val dataFood = FoodEntity(
            namaMakanan = nama,
            deskripsiMakanan = deskripsi
        )

        hasilMakanan.value = dataFood.saveData()
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                db.insert(dataFood)
            }
        }
    }
}


