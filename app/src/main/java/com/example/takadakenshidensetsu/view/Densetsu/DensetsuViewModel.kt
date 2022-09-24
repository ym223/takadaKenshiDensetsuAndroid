package com.example.takadakenshidensetsu.view.Densetsu

import androidx.lifecycle.*
import com.example.takadakenshidensetsu.model.DensetsuResult
import com.example.takadakenshidensetsu.repository.DensetsuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class DensetsuViewModel: ViewModel() {
    private val repository = DensetsuRepository()

    private val _densetsu = MutableLiveData<DensetsuResult>()
    val densetsu: LiveData<DensetsuResult> = _densetsu

    fun getDensetsu() {
        viewModelScope.launch {
            val result = repository.getDensetsu()
            _densetsu.value = result
        }
    }
}