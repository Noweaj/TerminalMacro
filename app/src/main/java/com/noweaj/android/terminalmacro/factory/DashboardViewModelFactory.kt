package com.noweaj.android.terminalmacro.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.noweaj.android.terminalmacro.data.repository.MacroRepository
import com.noweaj.android.terminalmacro.ui.dashboard.DashboardViewModel

class DashboardViewModelFactory(
    private val repository: MacroRepository
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DashboardViewModel(repository) as T        
    }
}