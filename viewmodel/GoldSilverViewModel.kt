package com.ozpehlivantugrul.widstation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozpehlivantugrul.widstation.model.GoldSilverModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class GoldSilverViewModel @Inject constructor(): ViewModel() {

    private val _goldSilverList = MutableLiveData<List<GoldSilverModel>>()
    val goldSilverList: LiveData<List<GoldSilverModel>> = _goldSilverList

    fun updateGoldSilverList(goldSilverList: List<GoldSilverModel>) {
        _goldSilverList.postValue(goldSilverList)
    }
}