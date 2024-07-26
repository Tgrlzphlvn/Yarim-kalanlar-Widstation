package com.ozpehlivantugrul.widstation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ozpehlivantugrul.widstation.model.OilPriceModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class OilPriceViewModel @Inject constructor(): ViewModel() {

    private val _oilPrice = MutableLiveData<OilPriceModel>()
    val oilPrice: LiveData<OilPriceModel> = _oilPrice

    private val _oilPriceList = MutableLiveData<List<OilPriceModel>>()
    val oilPriceList: LiveData<List<OilPriceModel>> = _oilPriceList

    fun getOilPriceModel(
        company: String,
        image: String,
        benzin: String,
        motorin: String,
        lpg: String
    ) {

        val model = OilPriceModel(
            company = company,
            image = image,
            benzin = benzin,
            motorin = motorin,
            lpg = lpg
        )

        _oilPrice.postValue(model)
    }

    fun updateOilPriceList(oilPriceList: List<OilPriceModel>) {
        _oilPriceList.postValue(oilPriceList)
    }
}