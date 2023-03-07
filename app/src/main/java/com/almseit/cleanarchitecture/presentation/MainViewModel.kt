package com.almseit.cleanarchitecture.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.almseit.cleanArchitecture.domain.model.SaveUserNameParam
import com.almseit.cleanArchitecture.domain.useCase.GetUserNameUseCase
import com.almseit.cleanArchitecture.domain.useCase.SaveUserNameUseCase

class MainViewModel(
    private val saveUserNameUseCase:SaveUserNameUseCase,
    private val getUserNameUseCase: GetUserNameUseCase

): ViewModel() {

    private val resultMutableLD = MutableLiveData<String>()
    var resultLD:LiveData<String> = resultMutableLD

    init {
        Log.d("AAA", "VM created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("AAA", "VM cleared")
    }

    fun save(text:String){
        val params = SaveUserNameParam(name = text)
        val resultData = saveUserNameUseCase.execute(params)
        resultMutableLD.value = "Save result = $resultData"

    }

    fun load(){
        val userName = getUserNameUseCase.execute()
        resultMutableLD.value = "${userName.firstName} ${userName.lastName}"

    }
}