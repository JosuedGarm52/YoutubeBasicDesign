package com.example.mybasicex

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mybasicex.ClFgRecyclerExDirections.Companion.actionFgRecyclerExToFgFormEx
import com.example.mybasicex.databinding.FgRecyclerExBinding

class ClFgRecyclerEx : Fragment() {
    private var _binding: FgRecyclerExBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FgRecyclerExBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(Singleton.listaVideos.size < 2){
            val video1 = video(
                Titulo = "Los secretos del universo",
                Canal = "Programador Junior",
                Duracion = 45.6,
                todoPublico = true,
                Visual = "Privado"
            )
            val video2 = video(
                Titulo = "Cómo cocinar un pastel perfecto",
                Canal = "Cocina con Ana",
                FechaSubida = "14/03/2024",
                Duracion = 12.3,
                todoPublico = true
            )
            val video3 = video(
                Titulo = "Viaje a la Patagonia",
                Canal = "Canal de viajes",
                Duracion = 60.0,
                Visual = "Oculto"
            )


            Singleton.listaVideos.add(video1)
            Singleton.listaVideos.add(video2)
            Singleton.listaVideos.add(video3)
        }

        val adapter = AdapterVideo{
            onItemClick(it)
        }

        binding.recyclerView1.adapter = adapter
        binding.recyclerView1.layoutManager = LinearLayoutManager(requireContext())
    }
    private fun onItemClick(it: video) {

        Toast.makeText(requireContext(), "Clic a ${it.Titulo}", Toast.LENGTH_SHORT).show()
        val action = ClFgRecyclerExDirections.actionFgRecyclerExToFgFormEx(it.Titulo)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}