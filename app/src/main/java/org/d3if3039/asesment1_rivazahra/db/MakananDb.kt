package org.d3if3039.asesment1_rivazahra.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FoodEntity::class], version = 1, exportSchema = false)

abstract class MakananDb : RoomDatabase() {

    abstract val dao: FoodDao

    companion object {
        @Volatile
        private var INSTANCE: MakananDb? = null

        fun getInstance(context: Context): MakananDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        MakananDb::class.java,
                        "makanan.db"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}