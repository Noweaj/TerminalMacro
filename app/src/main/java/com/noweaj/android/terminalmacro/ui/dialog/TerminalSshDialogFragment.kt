package com.noweaj.android.terminalmacro.ui.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.noweaj.android.terminalmacro.R
import com.noweaj.android.terminalmacro.databinding.FragmentTerminalSshDialogBinding
import com.noweaj.android.terminalmacro.ui.navigator.OnClickNavigator
import kotlinx.android.synthetic.main.fragment_terminal_ssh_dialog.view.*

class TerminalSshDialogFragment: DialogFragment(), OnClickNavigator {
    
    private lateinit var binding: FragmentTerminalSshDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTerminalSshDialogBinding.inflate(
            inflater,
            container,
            false
        )
        
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.b_terminal_ssh_dialog_cancel -> {
                dismiss()
            }
            R.id.b_terminal_ssh_dialog_connect -> {
                /*
                Bundle bundle = new Bundle();
                bundle.putString("mykey", "myvalue");
                Intent intent = new Intent().putExtras(bundle);
                getTargetFragment().onActivityResult(getTargetRequestCode(), Activity.RESULT_OK, intent);
                dismiss();
                 */
            }
        }
    }
}