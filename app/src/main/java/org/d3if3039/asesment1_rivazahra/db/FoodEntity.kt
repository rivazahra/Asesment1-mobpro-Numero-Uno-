package org.d3if3039.asesment1_rivazahra.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "makanan")
data class FoodEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0L,
    var namaMakanan : String,
    var deskripsiMakanan : String
)
