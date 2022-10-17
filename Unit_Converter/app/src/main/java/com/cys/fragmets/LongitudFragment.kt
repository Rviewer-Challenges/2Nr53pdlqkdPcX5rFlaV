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
            if (editText1.text.isNotEmpty()){
                println("Convertir!")
                convertir(spinner1, spinner2, textViewResultado, editText1)
            }else{
                Toast.makeText(context, "Introduzca un valor mayor a 0", Toast.LENGTH_LONG)
                println("Menor a 0")
                textViewResultado.setText("0.0")
            }
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
            "Milimetros" ->{
                convertirMilimetros(spinner2, textViewResultado, editText1)
            }
            "Centrímetros" ->{
                convertirCentimetros(spinner2, textViewResultado, editText1)
            }
            "Decímetros" ->{
                convertirDecimetros(spinner2, textViewResultado, editText1)
            }
            "Metros" ->{
                convertirMetros(spinner2, textViewResultado, editText1)
            }
            "Kilómetros" ->{
                convertirKilometros(spinner2, textViewResultado, editText1)
            }

        }
    }

    private fun convertirKilometros(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Milimetros"->{
                textView.setText(longitud.kilometrosMilimetros(editText1.text.toString().toDouble()).toString())
            }
            "Centrímetros"->{
                textView.setText(longitud.kilometrosCentimetros(editText1.text.toString().toDouble()).toString())
            }
            "Decímetros"->{
                textView.setText(longitud.kilometrosDecimetros(editText1.text.toString().toDouble()).toString())
            }
            "Metros"->{
                textView.setText(longitud.kilometrosMetros(editText1.text.toString().toDouble()).toString())
            }
            "Kilómetros"->{
                textView.setText(editText1.text.toString())
            }
        }
    }

    private fun convertirMetros(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Milimetros"->{
                textView.setText(longitud.metrosMilimetros(editText1.text.toString().toDouble()).toString())
            }
            "Centrímetros"->{
                textView.setText(longitud.metrosCentimetros(editText1.text.toString().toDouble()).toString())
            }
            "Decímetros"->{
                textView.setText(longitud.metrosDecimetros(editText1.text.toString().toDouble()).toString())
            }
            "Metros"->{
                textView.setText(editText1.text.toString())
            }
            "Kilómetros"->{
                textView.setText(longitud.metrosKilometros(editText1.text.toString().toDouble()).toString())
            }
        }
    }

    private fun convertirCentimetros(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Milimetros"->{
                textView.setText(longitud.centimetrosMilimetros(editText1.text.toString().toDouble()).toString())
            }
            "Centrímetros"->{
                textView.setText(editText1.text.toString())
            }
            "Decímetros"->{
                textView.setText(longitud.centimetrosDecimetros(editText1.text.toString().toDouble()).toString())
            }
            "Metros"->{
                textView.setText(longitud.centimetrosMetros(editText1.text.toString().toDouble()).toString())
            }
            "Kilómetros"->{
                textView.setText(longitud.centimetrosKilometros(editText1.text.toString().toDouble()).toString())
            }
        }
    }

    private fun convertirDecimetros(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Milimetros"->{
                textView.setText(longitud.decimetrosMilimetros(editText1.text.toString().toDouble()).toString())
            }
            "Centrímetros"->{
                textView.setText(longitud.decimetrosCentimetros(editText1.text.toString().toDouble()).toString())
            }
            "Decímetros"->{
                textView.setText(editText1.text.toString())
            }
            "Metros"->{
                textView.setText(longitud.decimetrosMetros(editText1.text.toString().toDouble()).toString())
            }
            "Kilómetros"->{
                textView.setText(longitud.decimetrosKilometros(editText1.text.toString().toDouble()).toString())
            }
        }
    }

    private fun convertirMilimetros(spinner2: Spinner, textView: TextView, editText1:EditText){

        when(spinner2.selectedItem){
            "Milimetros"->{
                textView.setText(editText1.text.toString())
            }
            "Centrímetros"->{
                textView.setText(longitud.milimetrosCentimetros(editText1.text.toString().toDouble()).toString())
            }
            "Decímetros"->{
                textView.setText(longitud.milimetrosDecimetros(editText1.text.toString().toDouble()).toString())
            }
            "Metros"->{
                textView.setText(longitud.milimetrosMetros(editText1.text.toString().toDouble()).toString())
            }
            "Kilómetros"->{
                textView.setText(longitud.milimetrosKilometros(editText1.text.toString().toDouble()).toString())
            }
        }

    }
}