package com.ozpehlivantugrul.widstation.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SpecialWritingViewModel @Inject constructor(
    private val sharedPref: SharedPreferences
): ViewModel() {

    private val specialText = "specialText"

    fun saveSpecialWriting(text: String) {
        sharedPref.edit().putString(specialText, text).apply()
    }
}