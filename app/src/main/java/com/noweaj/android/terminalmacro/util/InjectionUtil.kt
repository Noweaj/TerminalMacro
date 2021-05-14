package com.noweaj.android.terminalmacro.util

import androidx.lifecycle.ViewModelProvider
import com.noweaj.android.terminalmacro.data.local.MacroDao
import com.noweaj.android.terminalmacro.data.repository.MacroRepository
import com.noweaj.android.terminalmacro.factory.DashboardViewModelFactory

object InjectionUtil {
    fun provideMacroRepository(
        macroDao: MacroDao
    ): MacroRepository {
        return MacroRepository(macroDao)
    }
    
    fun provideDashboardViewModelFactory(
        repository: MacroRepository
    ): ViewModelProvider.Factory{
        return DashboardViewModelFactory(repository)
    }
}