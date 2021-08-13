package com.example.android_di_koin_example.ui

import androidx.lifecycle.*
import com.example.android_di_koin_example.api.GithubApi
import com.example.testkoin.model.ExampleModel
import com.timelysoft.tsjdomcom.service.ResultStatus
import kotlinx.coroutines.Dispatchers

class MainActivityViewModel constructor(private val githubApi: GithubApi): ViewModel() {

    //Вызываел его так
//    private val baseRep : BaseRepository by inject()
//
//    fun requestCountry() : LiveData<ResultStatus<ExampleModel>> {
//        return baseRep.requestCountryDetails()
//    }


    val result  = liveData<ResultStatus<ExampleModel>>(Dispatchers.IO) {
        try {
            val response = githubApi.news()
            when {
                response.isSuccessful -> {
                    if (response.body() != null) {
                        emit(ResultStatus.success(response.body()))
                    } else {
                        emit(ResultStatus.error("Ошибка при получении данных"))
                    }
                }
                else -> {
                    emit(ResultStatus.error("Не известная ошибка"))
                }
            }
        } catch (e: Exception) {
            emit(ResultStatus.netwrok("Проблеммы с подключением интернета", null))
        }
    }

}