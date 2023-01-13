package com.example.takadakenshidensetsu.view.DensetsuList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.takadakenshidensetsu.model.Densetsu
import com.example.takadakenshidensetsu.model.repository.DensetsuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DensetsuListViewModel @Inject constructor(
    private val repository: DensetsuRepository
) : ViewModel() {

    private val _densetsuAll = MutableLiveData<List<Densetsu>>()
    val densetsuAll: LiveData<List<Densetsu>> = _densetsuAll

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
        viewModelScope.launch(Dispatchers.IO) {
            _densetsuAll.postValue(repository.getDensetsuAll())
        }
    }
}
