package com.example.todo_app_kotlin.viewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {
    val count: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>(0)
    }
}