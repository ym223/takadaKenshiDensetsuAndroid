package com.example.takadakenshidensetsu.view.Densetsu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.takadakenshidensetsu.repository.DensetsuRepository
import kotlinx.coroutines.launch

class DensetsuViewModel: ViewModel() {
    private val repository = DensetsuRepository()

    private val _densetsu = MutableLiveData<String>()
    val densetsu: LiveData<String> = _densetsu

    fun getDensetsu() {
        viewModelScope.launch {
            val result = repository.getDensetsu()
            _densetsu.value = result.text
        }
    }
}