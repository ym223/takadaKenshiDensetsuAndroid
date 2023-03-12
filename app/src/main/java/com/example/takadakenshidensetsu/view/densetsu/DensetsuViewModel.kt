package com.example.takadakenshidensetsu.view.densetsu

import androidx.lifecycle.*
import com.example.takadakenshidensetsu.model.Densetsu
import com.example.takadakenshidensetsu.model.repository.DensetsuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DensetsuViewModel @Inject constructor(
    private val repository: DensetsuRepository
    ) : ViewModel() {
    private val _densetsu = MutableLiveData<Densetsu>()
    val densetsu: LiveData<Densetsu> = _densetsu

    fun getDensetsu() {
        viewModelScope.launch {
            val result = repository.getDensetsu()
            _densetsu.value = result
        }
    }

    fun addDensetsu(densetsu: Densetsu) {
        viewModelScope.launch(IO) {
            repository.insertDensetsu(densetsu)
        }
    }
}