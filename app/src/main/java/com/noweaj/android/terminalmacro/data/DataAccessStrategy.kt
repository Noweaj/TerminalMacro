package com.noweaj.android.terminalmacro.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.noweaj.android.terminalmacro.util.Resource
import kotlinx.coroutines.Dispatchers

fun <T> performLocalGetAllEntitiesOperation(
    databaseQuery: () -> List<T>
): LiveData<Resource<List<T>>> =
    liveData(Dispatchers.IO) { 
        emit(Resource.loading())
        val queryResult = databaseQuery.invoke()
        if(queryResult.isNotEmpty()){
            emit(Resource.success(queryResult))
        } else {
            emit(Resource.error("List empty.", null))
        }
    }