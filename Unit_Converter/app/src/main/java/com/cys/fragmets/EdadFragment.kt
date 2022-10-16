package com.cys.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.cys.unit_converter.R
import com.cys.utils.Edad

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [EdadFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EdadFragment : Fragment() {
    // TODO: Rename and change types of parameters

    var edad = Edad()

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
            if (editText1.text.isNotEmpty()){
                println("Convertir!")
                convertir(spinner1, spinner2, textViewResultado, editText1)
            }else{
                Toast.makeText(context, "Introduzca un valor mayor a 0", Toast.LENGTH_LONG)
                println("Menor a 0")
                textViewResultado.setText("0")
            }
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

    private fun convertirMercurio(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Tierra"->{
                textView.setText(edad.edadMercurioTierra(editText1.text.toString().toInt()).toString())
            }
            "Marte"->{
                textView.setText(edad.edadMercurioMarte(editText1.text.toString().toInt()).toString())
            }
            "Venus"->{
                textView.setText(edad.edadMercurioVenus(editText1.text.toString().toInt()).toString())
            }
            "Mercurio"->{
                textView.setText(editText1.text.toString())
            }
        }

    }

    private fun convertirVenus(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Tierra"->{
                textView.setText(edad.edadVenusTierra(editText1.text.toString().toInt()).toString())
            }
            "Marte"->{
                textView.setText(edad.edadVenusMarte(editText1.text.toString().toInt()).toString())
            }
            "Venus"->{
                textView.setText(editText1.text.toString())
            }
            "Mercurio"->{
                textView.setText(edad.edadVenusMercurio(editText1.text.toString().toInt()).toString())
            }
        }

    }

    private fun convertirMarte(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Tierra"->{
                textView.setText(edad.edadMarteTierra(editText1.text.toString().toInt()).toString())
            }
            "Marte"->{
                textView.setText(editText1.text.toString())
            }
            "Venus"->{
                textView.setText(edad.edadMarteVenus(editText1.text.toString().toInt()).toString())
            }
            "Mercurio"->{
                textView.setText(edad.edadMarteMercurio(editText1.text.toString().toInt()).toString())
            }
        }

    }

    private fun convertirTierra(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Tierra"->{
                textView.setText(editText1.text.toString())
            }
            "Marte"->{
                textView.setText(edad.edadTierraMarte(editText1.text.toString().toInt()).toString())
            }
            "Venus"->{
                textView.setText(edad.edadTierraVenus(editText1.text.toString().toInt()).toString())
            }
            "Mercurio"->{
                textView.setText(edad.edadTierraMercurio(editText1.text.toString().toInt()).toString())
            }
        }

    }

}