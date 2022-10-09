package com.cys.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.cys.unit_converter.R
import com.cys.utils.Longitud

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [LongitudFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LongitudFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private val longitud:Longitud = Longitud()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_longitud, container, false)
        var spinner1 = view.findViewById<Spinner>(R.id.spinner1)
        var spinner2 = view.findViewById<Spinner>(R.id.spinner2)
        var editText1 = view.findViewById<EditText>(R.id.editTextNumb1)
        var textViewResultado = view.findViewById<TextView>(R.id.textViewResultado)
        var buttonConvertir = view.findViewById<Button>(R.id.buttonConvertir)



        var adapterSpinner: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(requireContext(), R.array.longitude, android.R.layout.select_dialog_item)
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
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LongitudFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            LongitudFragment().apply {
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
            "mm milimetros" ->{
                convertirMilimetros(spinner2, textViewResultado, editText1)
            }
            "cm centrímetros" ->{
                convertirCentimetros(spinner2, textViewResultado, editText1)
            }
            "dm decímetros" ->{
                convertirDecimetros(spinner2, textViewResultado, editText1)
            }
            "m metros" ->{
                convertirMetros(spinner2, textViewResultado, editText1)
            }
            "km kilómetros" ->{
                convertirKilometros(spinner2, textViewResultado, editText1)
            }

        }
    }

    private fun convertirKilometros(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "mm milimetros"->{
                textView.setText(longitud.kilometrosMilimetros(editText1.text.toString().toDouble()).toString())
            }
            "cm centrímetros"->{
                textView.setText(longitud.kilometrosCentimetros(editText1.text.toString().toDouble()).toString())
            }
            "dm decímetros"->{
                textView.setText(longitud.kilometrosDecimetros(editText1.text.toString().toDouble()).toString())
            }
            "m metros"->{
                textView.setText(longitud.kilometrosMetros(editText1.text.toString().toDouble()).toString())
            }
            "km kilómetros"->{
                textView.setText(editText1.text.toString())
            }
        }
    }

    private fun convertirMetros(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "mm milimetros"->{
                textView.setText(longitud.metrosMilimetros(editText1.text.toString().toDouble()).toString())
            }
            "cm centrímetros"->{
                textView.setText(longitud.metrosCentimetros(editText1.text.toString().toDouble()).toString())
            }
            "dm decímetros"->{
                textView.setText(longitud.metrosDecimetros(editText1.text.toString().toDouble()).toString())
            }
            "m metros"->{
                textView.setText(editText1.text.toString())
            }
            "km kilómetros"->{
                textView.setText(longitud.metrosKilometros(editText1.text.toString().toDouble()).toString())
            }
        }
    }

    private fun convertirCentimetros(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "mm milimetros"->{
                textView.setText(longitud.centimetrosMilimetros(editText1.text.toString().toDouble()).toString())
            }
            "cm centrímetros"->{
                textView.setText(editText1.text.toString())
            }
            "dm decímetros"->{
                textView.setText(longitud.centimetrosDecimetros(editText1.text.toString().toDouble()).toString())
            }
            "m metros"->{
                textView.setText(longitud.centimetrosMetros(editText1.text.toString().toDouble()).toString())
            }
            "km kilómetros"->{
                textView.setText(longitud.centimetrosKilometros(editText1.text.toString().toDouble()).toString())
            }
        }
    }

    private fun convertirDecimetros(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "mm milimetros"->{
                textView.setText(longitud.decimetrosMilimetros(editText1.text.toString().toDouble()).toString())
            }
            "cm centrímetros"->{
                textView.setText(longitud.decimetrosCentimetros(editText1.text.toString().toDouble()).toString())
            }
            "dm decímetros"->{
                textView.setText(editText1.text.toString())
            }
            "m metros"->{
                textView.setText(longitud.decimetrosMetros(editText1.text.toString().toDouble()).toString())
            }
            "km kilómetros"->{
                textView.setText(longitud.decimetrosKilometros(editText1.text.toString().toDouble()).toString())
            }
        }
    }

    private fun convertirMilimetros(spinner2: Spinner, textView: TextView, editText1:EditText){

        when(spinner2.selectedItem){
            "mm milimetros"->{
                textView.setText(editText1.text.toString())
            }
            "cm centrímetros"->{
                textView.setText(longitud.milimetrosCentimetros(editText1.text.toString().toDouble()).toString())
            }
            "dm decímetros"->{
                textView.setText(longitud.milimetrosDecimetros(editText1.text.toString().toDouble()).toString())
            }
            "m metros"->{
                textView.setText(longitud.milimetrosMetros(editText1.text.toString().toDouble()).toString())
            }
            "km kilómetros"->{
                textView.setText(longitud.milimetrosKilometros(editText1.text.toString().toDouble()).toString())
            }
        }

    }
}