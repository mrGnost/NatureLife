package com.example.naturelife.ui.fragments.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.naturelife.domain.model.Route
import com.example.naturelife.domain.repository.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class MapViewModel @Inject constructor(
    val databaseRepository: DatabaseRepository
) : ViewModel() {
    fun addRoute() {
        viewModelScope.launch {
            databaseRepository.addRoute(
                Route(
                    userId = 0,
                    date = Calendar.getInstance().time,
                    routeImage = null
                )
            )
        }
    }
}