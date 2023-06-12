package org.d3if3039.asesment1_rivazahra.ui.kumpulanMakanan

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3039.asesment1_rivazahra.model.Food
import org.d3if3039.asesment1_rivazahra.model.KumpulanMakanan
import org.d3if3039.asesment1_rivazahra.network.MakananApi

class KumpulanViewModel : ViewModel() {

private val data = MutableLiveData<List<KumpulanMakanan>>()
private val status = MutableLiveData<MakananApi.ApiStatus>()
  init{
      retrieveData()
  }
    private fun retrieveData() {
        viewModelScope.launch(Dispatchers.IO) {
            status.postValue(MakananApi.ApiStatus.LOADING)
            try {
                data.postValue(MakananApi.service.getMakanan())
                status.postValue(MakananApi.ApiStatus.SUCCESS)
            } catch (e: java.lang.Exception) {
                Log.d("KumpulanViewModel", "Failure:${e.message}")
                status.postValue(MakananApi.ApiStatus.FAILED)
            }
        }
    }

    fun getData(): LiveData<List<KumpulanMakanan>> = data
    fun getStatus(): LiveData<MakananApi.ApiStatus> = status



}