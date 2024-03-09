package com.example.mybasicex

import android.app.AlertDialog
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.example.mybasicex.databinding.FgFormExBinding
import android.widget.EditText

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
    val args: ClFgFormEXArgs by navArgs()
    var bandera = false
    lateinit var clave: String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //visibilidad del boton
        binding.btnBorrar.visibility = View.GONE

        if (args.Titulo != "nulo") {
            //encontar elemento en la lista del recyclcer view
            val materiaEncontrada = Singleton.listaVideos.find { it.Titulo == args.Titulo }
            if (materiaEncontrada != null) {
                // Asigna los valores a los EditText
                binding.edtTitulo.setText(materiaEncontrada.Titulo)
                binding.edtCanal.setText(materiaEncontrada.Canal)
                val x: String = materiaEncontrada.FechaSubida.toString()
                binding.edtDate.setText(x)

            } else {
                Snackbar.make(view, "Video no encontrado", Snackbar.LENGTH_SHORT).show()
            }
            bandera = true
            clave = args.Titulo
            if(bandera){
                binding.btnSig.text = "Actualizar"
                binding.btnBorrar.visibility = View.VISIBLE
            }else{
                binding.btnSig.text = "Subir"
                binding.btnBorrar.visibility = View.GONE
            }
        }

        binding.btnSig.setOnClickListener{

            val Titulo = binding.edtTitulo.text.toString()
            val Canal = binding.edtCanal.text.toString()
            val Fecha = binding.edtDate.text.toString()
            val Duracion:Double = binding.edtDuracion.text.toString().toDouble()
            val Publico: Boolean = binding.chkPublico.isChecked
            var visualidad: String
            visualidad = if(binding.rdbPublico.isChecked){
                "Publico"
            }else if(binding.rdbOculto.isChecked){
                "Oculto"
            }else{
                "Privado"
            }

            val videoInfo = video(Titulo,Canal,Fecha,Duracion,Publico,visualidad)
            if (bandera) {
                val indiceActualizar = Singleton.listaVideos.indexOfFirst { it.Titulo == clave }
                if (indiceActualizar != -1) {
                    // Actualiza el elemento en la lista
                    Singleton.listaVideos[indiceActualizar] = videoInfo

                    binding.edtTitulo.text =
                        Editable.Factory.getInstance().newEditable(Titulo)
                    binding.edtDate.text =
                        Editable.Factory.getInstance().newEditable(Fecha)
                    binding.edtDuracion.text =
                        Editable.Factory.getInstance().newEditable(binding.edtDuracion.text.toString())
                    Snackbar.make(
                        view,
                        "Elemento modificado",
                        Snackbar.LENGTH_SHORT
                    ).show()

                } else {
                    // El elemento no se encontró, realiza alguna acción o muestra un mensaje de error
                    Snackbar.make(
                        view,
                        "Elemento no encontrado para actualizar",
                        Snackbar.LENGTH_SHORT
                    ).show()
                }
            } else {
                //guardar en la lista del recyclcer view
                Singleton.listaVideos.add(videoInfo)
            }


            Snackbar.make(view, "Dato Agregado", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
            findNavController().navigate(R.id.action_fg_form_ex_to_fg_recycler_ex)
        }
        binding.btnBorrar.setOnClickListener{
            val actCompEncontrada = Singleton.listaVideos.find { it.Titulo == args.Titulo }

            if (actCompEncontrada != null) {
                val builder = AlertDialog.Builder(requireContext())
                builder.setTitle("Confirmación")
                builder.setMessage("¿Estás seguro de que deseas eliminar '${actCompEncontrada.Titulo}'?")

                // Configurar el botón de confirmación
                builder.setPositiveButton("Sí") { _, _ ->
                    // Remover el elemento encontrado de la lista
                    Singleton.listaVideos.remove(actCompEncontrada)
                    // Realizar otras operaciones si es necesario
                    Snackbar.make(view, "Video:. '${args.Titulo}' eliminada", Snackbar.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_fg_form_ex_to_fg_recycler_ex)
                }

                // Configurar el botón de cancelación
                builder.setNegativeButton("No") { _, _ ->
                    Snackbar.make(view, "Eliminación cancelada", Snackbar.LENGTH_SHORT).show()
                }

                // Mostrar el cuadro de diálogo
                builder.show()
            } else {
                Snackbar.make(view, "Video no encontrado", Snackbar.LENGTH_SHORT).show()
            }

        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}