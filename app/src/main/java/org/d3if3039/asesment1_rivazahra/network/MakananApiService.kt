package org.d3if3039.asesment1_rivazahra.network

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import org.d3if3039.asesment1_rivazahra.model.KumpulanMakanan
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Url

private const val BASE_URL = "https://raw.githubusercontent.com/rivazahra/Asesment1-mobpro-Numero-Uno-/static-api/static_api.json"

private val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

interface MakananApiService {
    @GET("static-api.json")
    suspend fun getMakanan() : List<KumpulanMakanan>
}
object MakananApi {
    val service: MakananApiService by lazy {
        retrofit.create(MakananApiService::class.java)
    }

    fun getMakananUrl(imageUrl: String): String {
        return "BASE_URL$imageUrl.jpg"
    }
}
    enum class ApiStatus{LOADING, SUCCESS, FAILED}
