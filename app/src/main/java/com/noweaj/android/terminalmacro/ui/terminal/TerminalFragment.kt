package com.noweaj.android.terminalmacro.ui.terminal

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.noweaj.android.terminalmacro.R
import com.noweaj.android.terminalmacro.databinding.FragmentTerminalBinding
import com.noweaj.android.terminalmacro.shell.ShellExecutor
import com.noweaj.android.terminalmacro.ui.navigator.OnClickNavigator
import com.noweaj.android.terminalmacro.util.Log

class TerminalFragment: Fragment(), OnClickNavigator {
    private val TAG = TerminalFragment::class.java.simpleName
    
    private lateinit var binding: FragmentTerminalBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTerminalBinding.inflate(
            inflater,
            container,
            false
        )
        binding.viewModel = ViewModelProvider(this).get(TerminalViewModel::class.java)
        binding.viewModel!!.setNavigator(this)
        
        setView()
        observe()
        
        return binding.root
    }
    
    private fun setView(){
        binding.tvTerminalConsole.maxLines = 1000
        binding.tvTerminalConsole.isVerticalScrollBarEnabled = true
        binding.tvTerminalConsole.movementMethod = ScrollingMovementMethod()
        
        binding.etTerminalInput.setOnKeyListener { v, keyCode, event -> 
            if(event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER){
                binding.viewModel!!.onClick(binding.bTerminalEnter)
            }
            true
        }
    }

    override fun onResume() {
        super.onResume()
    }
    
    private fun observe(){
        binding.viewModel!!.console.observe(viewLifecycleOwner, Observer{
            binding.tvTerminalConsole.append(it)
        })
    }
    
    override fun onClick(v: View) {
        when(v.id){
            R.id.b_terminal_enter -> {
                execute(binding.etTerminalInput.text.toString())
            }
        }
    }
    
    private fun execute(msg: String){
        binding.etTerminalInput.text.clear()
        binding.viewModel!!.executeCommand(msg)
    }
}