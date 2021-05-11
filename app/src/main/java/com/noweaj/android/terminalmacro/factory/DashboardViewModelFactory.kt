package com.noweaj.android.terminalmacro.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.noweaj.android.terminalmacro.ui.dashboard.DashboardViewModel

class DashboardViewModelFactory(
    
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return DashboardViewModel() as T        
    }
}