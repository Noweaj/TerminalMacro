package com.noweaj.android.terminalmacro.ui.terminal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.noweaj.android.terminalmacro.databinding.FragmentTerminalBinding

class TerminalFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentTerminalBinding.inflate(
            inflater,
            container,
            false
        )
        
        return binding.root
    }
}