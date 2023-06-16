package org.d3if3039.asesment1_rivazahra.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if3039.asesment1_rivazahra.model.KumpulanMakanan
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://raw.githubusercontent.com/rivazahra/Asesment1-mobpro-Numero-Uno-/static-api/"
//private const val BASE_URL = "https://raw.githubusercontent.com/disyudhis/Tanam/static-api/"

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()

private val retrofit =
    Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL)
        .build()

interface MakananApiService {
    @GET("static_api.json")
    suspend fun getMakanan(): List<KumpulanMakanan>
}

object MakananApi {
    val service: MakananApiService by lazy {
        retrofit.create(MakananApiService::class.java)
    }

    fun getMakananUrl(imageUrl: String): String {
        return "$BASE_URL$imageUrl.jpg"
    }
}

enum class ApiStatus { LOADING, SUCCESS, FAILED }
