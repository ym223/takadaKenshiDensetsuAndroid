package com.example.takadakenshidensetsu.view.Densetsu

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

    private val _densetsuAll = MutableLiveData<List<Densetsu>>()
    val densetsuAll: LiveData<List<Densetsu>> = _densetsuAll

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

    fun getDensetsuAll(): MutableList<Densetsu?> {
        val densetsuListAll = MutableList<Densetsu?>(232) { null }
        fetchDensetsuAll()
        densetsuAll.value?.let {
            for (densetsu in it) {
                densetsuListAll[densetsu.No] = densetsu
            }
        }
        return densetsuListAll
    }

    fun fetchDensetsuAll() {
        viewModelScope.launch(IO) {
            _densetsuAll.postValue(repository.getDensetsuAll())
        }
    }
}