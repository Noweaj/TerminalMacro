package com.noweaj.android.terminalmacro.ui.dialog

import android.view.View
import androidx.lifecycle.ViewModel
import com.noweaj.android.terminalmacro.ui.navigator.OnClickNavigator
import java.lang.ref.WeakReference

class TerminalSshDialogViewModel: ViewModel() {
    
    private var navigator: WeakReference<OnClickNavigator>? = null
    fun setNavigator(navigator: OnClickNavigator){
        this.navigator = WeakReference(navigator)
    }
    
    fun onClick(v: View){
        navigator?.let { 
            it.get()!!.onClick(v)
        }
    }
}