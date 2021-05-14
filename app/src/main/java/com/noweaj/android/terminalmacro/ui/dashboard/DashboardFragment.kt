package com.noweaj.android.terminalmacro.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.noweaj.android.terminalmacro.data.local.AppDatabase
import com.noweaj.android.terminalmacro.databinding.FragmentDashboardBinding
import com.noweaj.android.terminalmacro.util.InjectionUtil
import com.noweaj.android.terminalmacro.util.Log
import com.noweaj.android.terminalmacro.util.Resource

class DashboardFragment: Fragment() {
    private val TAG = DashboardFragment::class.java.simpleName
    
    private val viewModel: DashboardViewModel by viewModels{
        InjectionUtil.provideDashboardViewModelFactory(
            InjectionUtil.provideMacroRepository(
                AppDatabase.getInstance(requireContext()).macroDao()
            )
        )
    }
    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDashboardBinding.inflate(
            inflater,
            container,
            false
        )
        binding.viewModel = viewModel
        
        observe()
        
        return binding.root
    }
    
    private fun observe(){
        binding.viewModel!!.macroEntitiesResult.observe(viewLifecycleOwner, Observer {
            Log.d(TAG, "status: ${it.status}")
            when(it.status){
                Resource.Status.LOADING -> {
                    
                }
                Resource.Status.SUCCESS -> {
                    
                }
                Resource.Status.ERROR -> {
                    
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        binding.viewModel!!.updateMacroEntities()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }
}