package com.noweaj.android.terminalmacro.ui.terminal

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.noweaj.android.terminalmacro.shell.ShellExecutor
import com.noweaj.android.terminalmacro.ui.navigator.OnClickNavigator
import com.noweaj.android.terminalmacro.util.Log
import java.lang.ref.WeakReference

class TerminalViewModel: ViewModel() {
    private val TAG = TerminalViewModel::class.java.simpleName
    
    var consoleText = ""
    
    private val _appendConsole = MutableLiveData<String>()
//    private val _console = _appendConsole.switchMap {
//        val result = appendConsole(consoleText, it)
//        consoleText = result.value!!
//        Log.d(TAG, "consoleText: $consoleText")
//        result
//    }
    private val _console = MutableLiveData<String>()
    val console: LiveData<String> = _console
    
    fun appendConsole(msg: String){
        _appendConsole.postValue(msg)
    }
    
    private fun appendConsole(org: String, new: String): LiveData<String>{
        val result = "$org\n$new"
        return MutableLiveData<String>(result)
    }
    
    fun executeCommand(command: String){
        val commandStr = "${ShellExecutor.execute("pwd")} > $ $command"
        Log.d(TAG, commandStr)
//        _appendConsole.postValue(commandStr)
//        _appendConsole.postValue(ShellExecutor.execute(command).toString())
        _console.postValue(commandStr)
        _console.postValue(ShellExecutor.execute(command))
    }
    
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