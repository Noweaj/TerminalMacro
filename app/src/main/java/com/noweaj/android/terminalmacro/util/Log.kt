package com.noweaj.android.terminalmacro.util

import android.util.Log

object Log {
    private var isVisible = true
    
    fun setVisibility(flag: Boolean){
        this.isVisible = flag
    }
    
    fun d(tag: String, msg: String){
        if(isVisible) Log.d(tag, msg)
    }
}