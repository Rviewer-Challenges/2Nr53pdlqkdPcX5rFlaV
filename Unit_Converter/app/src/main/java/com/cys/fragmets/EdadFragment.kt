package com.cys.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.cys.unit_converter.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [EdadFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EdadFragment : Fragment() {
    // TODO: Rename and change types of parameters

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_edad, container, false)
        var spinner1 = view.findViewById<Spinner>(R.id.spinner1)
        var spinner2 = view.findViewById<Spinner>(R.id.spinner2)
        var editText1 = view.findViewById<EditText>(R.id.editTextNumb1)
        var textViewResultado = view.findViewById<TextView>(R.id.textViewResultado)
        var buttonConvertir = view.findViewById<Button>(R.id.buttonConvertir)



        var adapterSpinner: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(requireContext(), R.array.planetas, android.R.layout.select_dialog_item)
        spinner1!!.setAdapter(adapterSpinner)
        spinner2!!.setAdapter(adapterSpinner)

        buttonConvertir.setOnClickListener {
            println("Convertir!")
            convertir(spinner1, spinner2, textViewResultado, editText1)
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            EdadFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    fun convertir(
        spinner1: Spinner,
        spinner2: Spinner,
        textViewResultado: TextView,
        editText1: EditText
    ){
        when(spinner1.selectedItem){
            "Tierra" ->{
                convertirTierra(spinner2, textViewResultado, editText1)
            }
            "Marte" ->{
                convertirMarte(spinner2, textViewResultado, editText1)
            }
            "Venus" ->{
                convertirVenus(spinner2, textViewResultado, editText1)
            }
            "Mercurio" ->{
                convertirMercurio(spinner2, textViewResultado, editText1)
            }

        }
    }

    private fun convertirMercurio(spinner2: Spinner, textViewResultado: TextView, editText1: EditText) {


    }

    private fun convertirVenus(spinner2: Spinner, textViewResultado: TextView, editText1: EditText) {


    }

    private fun convertirMarte(spinner2: Spinner, textViewResultado: TextView, editText1: EditText) {


    }

    private fun convertirTierra(spinner2: Spinner, textViewResultado: TextView, editText1: EditText) {


    }

}