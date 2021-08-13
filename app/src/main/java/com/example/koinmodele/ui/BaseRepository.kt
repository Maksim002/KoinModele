package com.example.android_di_koin_example.ui

import androidx.lifecycle.LiveData
import com.example.testkoin.model.ExampleModel
import com.timelysoft.tsjdomcom.service.ResultStatus

interface BaseRepository {
    fun requestCountryDetails() : LiveData<ResultStatus<ExampleModel>>
}