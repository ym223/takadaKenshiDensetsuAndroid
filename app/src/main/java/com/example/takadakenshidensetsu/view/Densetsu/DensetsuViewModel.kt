package com.example.takadakenshidensetsu.view.Densetsu

import androidx.lifecycle.*
import com.example.takadakenshidensetsu.model.DensetsuResult
import com.example.takadakenshidensetsu.model.repository.DensetsuRepository
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class DensetsuViewModel(private val repository: DensetsuRepository) : ViewModel() {
    private val _densetsu = MutableLiveData<DensetsuResult>()
    val densetsu: LiveData<DensetsuResult> = _densetsu

    private val _densetsuAll = MutableLiveData<List<DensetsuResult>>()
    val densetsuAll: LiveData<List<DensetsuResult>> = _densetsuAll

    fun getDensetsu() {
        viewModelScope.launch {
            val result = repository.getDensetsu()
            _densetsu.value = result
        }
    }

    fun addDensetsu(densetsu: DensetsuResult) {
        viewModelScope.launch(IO) {
            repository.insertDensetsu(densetsu)
        }
    }

    fun getDensetsuAll() : MutableList<DensetsuResult?> {
            val densetsuListAll = MutableList<DensetsuResult?>(232) { null }
            fetchDensetsuAll()
            densetsuAll.value?.let {
                for(densetsu in it){
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

    class Factory(private val densetsuRepository: DensetsuRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return DensetsuViewModel(this.densetsuRepository) as T
        }
    }
}