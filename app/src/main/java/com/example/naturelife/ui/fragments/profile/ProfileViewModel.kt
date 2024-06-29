package com.example.naturelife.ui.fragments.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naturelife.domain.model.Route
import com.example.naturelife.domain.repository.DatabaseRepository
import com.example.naturelife.ui.adapters.RoutesAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    val databaseRepository: DatabaseRepository
) : ViewModel() {
    val adapter = RoutesAdapter()

    private val routesFlow = MutableStateFlow<List<Route>>(emptyList())

    init {
        viewModelScope.launch {
            databaseRepository.getRoutes().collect {
                routesFlow.value = it
            }
        }
    }

    fun startDataObserver() {
        viewModelScope.launch(Dispatchers.Default) {
            routesFlow.collect {
                withContext(Dispatchers.Main) {
                    updateRecyclerData(it)
                }
            }
        }
    }

    private fun updateRecyclerData(elements: List<Route>) {
        adapter.apply {
            data = elements
        }
    }
}