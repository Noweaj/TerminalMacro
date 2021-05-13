package com.noweaj.android.terminalmacro.ui.ssh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.noweaj.android.terminalmacro.databinding.FragmentSshBinding

class SshFragment: Fragment() {
    
    private lateinit var binding: FragmentSshBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSshBinding.inflate(
            inflater,
            container,
            false
        )
        
        return binding.root
    }
}