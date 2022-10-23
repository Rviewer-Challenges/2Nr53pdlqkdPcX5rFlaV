package com.cys.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.cys.unit_converter.R
import com.cys.utils.Longitud
import com.cys.utils.Utils


class LongitudFragment : Fragment() {

    private val longitud:Longitud = Longitud()
    private val utils = Utils()
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
                convertir(spinner1, spinner2, textViewResultado, editText1)
            }else{
                Toast.makeText(context, "Introduzca un valor mayor a 0", Toast.LENGTH_LONG).show()
                textViewResultado.setText("0.0")
            }
        }


        return view
    }

    companion object {

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
                textView.setText(utils.decimalFormat(longitud.kilometrosMilimetros(editText1.text.toString().toDouble())))
            }
            "Centrímetros"->{
                textView.setText(utils.decimalFormat(longitud.kilometrosCentimetros(editText1.text.toString().toDouble())))
            }
            "Decímetros"->{
                textView.setText(utils.decimalFormat(longitud.kilometrosDecimetros(editText1.text.toString().toDouble())))
            }
            "Metros"->{
                textView.setText(utils.decimalFormat(longitud.kilometrosMetros(editText1.text.toString().toDouble())))
            }
            "Kilómetros"->{
                textView.setText(editText1.text.toString())
            }
        }
    }

    private fun convertirMetros(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Milimetros"->{
                textView.setText(utils.decimalFormat(longitud.metrosMilimetros(editText1.text.toString().toDouble())))
            }
            "Centrímetros"->{
                textView.setText(utils.decimalFormat(longitud.metrosCentimetros(editText1.text.toString().toDouble())))
            }
            "Decímetros"->{
                textView.setText(utils.decimalFormat(longitud.metrosDecimetros(editText1.text.toString().toDouble())))
            }
            "Metros"->{
                textView.setText(editText1.text.toString())
            }
            "Kilómetros"->{
                textView.setText(utils.decimalFormat(longitud.metrosKilometros(editText1.text.toString().toDouble())))
            }
        }
    }

    private fun convertirCentimetros(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Milimetros"->{
                textView.setText(utils.decimalFormat(longitud.centimetrosMilimetros(editText1.text.toString().toDouble())))
            }
            "Centrímetros"->{
                textView.setText(editText1.text.toString())
            }
            "Decímetros"->{
                textView.setText(utils.decimalFormat(longitud.centimetrosDecimetros(editText1.text.toString().toDouble())))
            }
            "Metros"->{
                textView.setText(utils.decimalFormat(longitud.centimetrosMetros(editText1.text.toString().toDouble())))
            }
            "Kilómetros"->{
                textView.setText(utils.decimalFormat(longitud.centimetrosKilometros(editText1.text.toString().toDouble())))
            }
        }
    }

    private fun convertirDecimetros(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Milimetros"->{
                textView.setText(utils.decimalFormat(longitud.decimetrosMilimetros(editText1.text.toString().toDouble())))
            }
            "Centrímetros"->{
                textView.setText(utils.decimalFormat(longitud.decimetrosCentimetros(editText1.text.toString().toDouble())))
            }
            "Decímetros"->{
                textView.setText(editText1.text.toString())
            }
            "Metros"->{
                textView.setText(utils.decimalFormat(longitud.decimetrosMetros(editText1.text.toString().toDouble())))
            }
            "Kilómetros"->{
                textView.setText(utils.decimalFormat(longitud.decimetrosKilometros(editText1.text.toString().toDouble())))
            }
        }
    }

    private fun convertirMilimetros(spinner2: Spinner, textView: TextView, editText1:EditText){

        when(spinner2.selectedItem){
            "Milimetros"->{
                textView.setText(editText1.text.toString())
            }
            "Centrímetros"->{
                textView.setText(utils.decimalFormat(longitud.milimetrosCentimetros(editText1.text.toString().toDouble())))
            }
            "Decímetros"->{
                textView.setText(utils.decimalFormat(longitud.milimetrosDecimetros(editText1.text.toString().toDouble())))
            }
            "Metros"->{
                textView.setText(utils.decimalFormat(longitud.milimetrosMetros(editText1.text.toString().toDouble())))
            }
            "Kilómetros"->{
                textView.setText(utils.decimalFormat(longitud.milimetrosKilometros(editText1.text.toString().toDouble())))
            }
        }

    }
}