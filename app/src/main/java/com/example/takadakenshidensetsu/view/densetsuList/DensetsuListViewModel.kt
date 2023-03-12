package com.example.takadakenshidensetsu.view.densetsuList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.takadakenshidensetsu.model.Densetsu
import com.example.takadakenshidensetsu.model.repository.DensetsuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DensetsuListViewModel @Inject constructor(
    private val repository: DensetsuRepository
) : ViewModel() {

    private val _densetsuAll = MutableStateFlow<List<Densetsu>>(listOf())
    val densetsuAll: StateFlow<List<Densetsu>> = _densetsuAll

    fun getDensetsuAll(): MutableList<Densetsu?> {
        val densetsuListAll = MutableList<Densetsu?>(232) { null }
        fetchDensetsuAll()
        _densetsuAll.value.let {
            for (densetsu in it) {
                densetsuListAll[densetsu.No] = densetsu
            }
        }
        return densetsuListAll
    }

    fun fetchDensetsuAll() {
        viewModelScope.launch(Dispatchers.IO) {
            _densetsuAll.update { repository.getDensetsuAll() }
        }
    }
}
