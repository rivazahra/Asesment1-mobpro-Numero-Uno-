package org.d3if3039.asesment1_rivazahra.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FoodDao {
@Insert
fun insert(makanan: FoodEntity)

@Query("SELECT * FROM makanan ORDER  BY id DESC")
fun getLastFood(): LiveData<List<FoodEntity>>

@Query("SELECT * FROM makanan WHERE namaMakanan = :nama ")
fun cariMakan(nama: String): LiveData<List<FoodEntity>>

@Query("DELETE FROM makanan")
fun clearData()
}