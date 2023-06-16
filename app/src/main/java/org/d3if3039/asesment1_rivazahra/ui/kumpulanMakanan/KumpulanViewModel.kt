package org.d3if3039.asesment1_rivazahra.ui.kumpulanMakanan

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3039.asesment1_rivazahra.model.KumpulanMakanan
import org.d3if3039.asesment1_rivazahra.network.ApiStatus
import org.d3if3039.asesment1_rivazahra.network.MakananApi
import org.d3if3039.asesment1_rivazahra.network.UpdateWorker
import java.util.concurrent.TimeUnit

class KumpulanViewModel : ViewModel() {

    private val data = MutableLiveData<List<KumpulanMakanan>>()
    private val status = MutableLiveData<ApiStatus>()

    init {
        retrieveData()
    }

    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.postValue(ApiStatus.LOADING)
            try {
                data.postValue(MakananApi.service.getMakanan())
                status.postValue(ApiStatus.SUCCESS)
            } catch (e: Exception) {
                Log.d("KumpulanViewModel", "Failure:${e.message}")
                status.postValue(ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<KumpulanMakanan>> = data
    fun getStatus(): LiveData<ApiStatus> = status

    fun scheduleUpdater(app: Application) {
        val request = OneTimeWorkRequestBuilder<UpdateWorker>().setInitialDelay(1, TimeUnit.MINUTES).build()
        WorkManager.getInstance(app).enqueueUniqueWork(
            UpdateWorker.WORK_NAME,
            ExistingWorkPolicy.REPLACE, request
        )
    }
}