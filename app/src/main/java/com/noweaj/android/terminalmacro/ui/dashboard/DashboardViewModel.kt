package com.noweaj.android.terminalmacro.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.noweaj.android.terminalmacro.data.entity.MacroEntity
import com.noweaj.android.terminalmacro.data.repository.MacroRepository
import com.noweaj.android.terminalmacro.util.Resource

class DashboardViewModel(
    repository: MacroRepository
): ViewModel() {
    
    private val _macroEntities = MutableLiveData<Unit>()
    private val _macroEntitiesResult = _macroEntities.switchMap { 
        repository.getAllMacroEntities()
    }
    val macroEntitiesResult: LiveData<Resource<List<MacroEntity>>> = _macroEntitiesResult
    
    fun updateMacroEntities(){
        _macroEntities.postValue(Unit)
    }
}