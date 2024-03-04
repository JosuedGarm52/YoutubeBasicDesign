package com.example.mybasicex

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.example.mybasicex.databinding.FgFormExBinding

class ClFgFormEX : Fragment() {

    private var _binding: FgFormExBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("FragmentMenuActComp", "OnCreateView: paso por aqui")
        _binding = FgFormExBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnSig.setOnClickListener{
            val ejemplo1 = binding.edtText1.text.toString()
            val ejemplo2 = binding.edtText2.text.toString()

            val Ejempliplo = ejemplo(ejemplo1, ejemplo2)

            Singleton.singEjemplo.add(Ejempliplo)
            Snackbar.make(view, "Dato Agregado", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            findNavController().navigate(R.id.action_fg_form_ex_to_fg_recycler_ex)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}