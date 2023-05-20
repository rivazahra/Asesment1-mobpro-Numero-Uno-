package org.d3if3039.asesment1_rivazahra.model
import org.d3if3039.asesment1_rivazahra.db.FoodEntity

fun FoodEntity.saveData(): Food {
    val nama = namaMakanan
    val deskripsi = deskripsiMakanan
    return Food(nama,deskripsi)
}