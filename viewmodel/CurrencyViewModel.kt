package com.ozpehlivantugrul.widstation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozpehlivantugrul.widstation.model.CurrencyModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CurrencyViewModel @Inject constructor(): ViewModel() {

    private val _currencyList = MutableLiveData<List<CurrencyModel>>()
    val currencyList: LiveData<List<CurrencyModel>> = _currencyList

    fun updateCurrencyList(currencyList: List<CurrencyModel>) {
        _currencyList.postValue(currencyList)
    }
}