package com.cys.fragmets
/**
 * Author: Sara Corrals Santos
 */

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.cys.unit_converter.R
import com.cys.utils.Datos
import com.cys.utils.Utils

/**
 * Class that is responsible for giving functionality to
 * the interface of the fragment that converts data sizes
 */
class DatosFragment : Fragment() {
    //Variables
    private val datos = Datos()
    private val utils = Utils()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    //Function that is responsible for giving functionality to
    // the elements of the interface
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_datos, container, false)
        var spinner1 = view.findViewById<Spinner>(R.id.spinner1)
        var spinner2 = view.findViewById<Spinner>(R.id.spinner2)
        var editText1 = view.findViewById<EditText>(R.id.editTextNumb1)
        var textViewResultado = view.findViewById<TextView>(R.id.textViewResultado)
        var buttonConvertir = view.findViewById<Button>(R.id.buttonConvertir)


        var adapterSpinner: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(requireContext(), R.array.datos, android.R.layout.select_dialog_item)
        spinner1!!.setAdapter(adapterSpinner)
        spinner2!!.setAdapter(adapterSpinner)

        buttonConvertir.setOnClickListener {
            if (editText1.text.isNotEmpty()){
                println("Convertir!")
                convertir(spinner1, spinner2, textViewResultado, editText1)
            }else{
                Toast.makeText(context, "Introduzca un valor mayor a 0", Toast.LENGTH_LONG).show()
                println("Menor a 0")
                textViewResultado.setText("0.0")
            }
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            DatosFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    //Function that converts data sizes
    fun convertir(
        spinner1: Spinner,
        spinner2: Spinner,
        textViewResultado: TextView,
        editText1: EditText
    ){
        when(spinner1.selectedItem){
            "Byte" ->{
                convertirBytes(spinner2, textViewResultado, editText1)
            }
            "Kilobyte" ->{
                convertirKilobytes(spinner2, textViewResultado, editText1)
            }
            "Megabyte" ->{
                convertirMegabytes(spinner2, textViewResultado, editText1)
            }
            "Gigabyte" ->{
                convertirGigabytes(spinner2, textViewResultado, editText1)
            }
            "Terabyte" ->{
                convertirTerabytes(spinner2, textViewResultado, editText1)
            }

        }
    }

    //Function that converts Terabyte to another unit
    private fun convertirTerabytes(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Byte"->{
                textView.setText(utils.decimalFormat(datos.terabyteByte(editText1.text.toString().toDouble())))
            }
            "Kilobyte"->{
                textView.setText(utils.decimalFormat(datos.terabyteKilobyte(editText1.text.toString().toDouble())))
            }
            "Megabyte"->{
                textView.setText(utils.decimalFormat(datos.terabyteMegabyte(editText1.text.toString().toDouble())))
            }
            "Gigabyte"->{
                textView.setText(utils.decimalFormat(datos.terabyteGigabyte(editText1.text.toString().toDouble())))
            }
            "Terabyte"->{
                textView.setText(editText1.text.toString())
            }
        }
    }

    //Function that converts Gigabyte to another unit
    private fun convertirGigabytes(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Byte"->{
                textView.setText(utils.decimalFormat(datos.gigabyteByte(editText1.text.toString().toDouble())))
            }
            "Kilobyte"->{
                textView.setText(utils.decimalFormat(datos.gigabyteKilobyte(editText1.text.toString().toDouble())))
            }
            "Megabyte"->{
                textView.setText(utils.decimalFormat(datos.gigabyteMegabyte(editText1.text.toString().toDouble())))
            }
            "Gigabyte"->{
                textView.setText(editText1.text.toString())
            }
            "Terabyte"->{
                textView.setText(utils.decimalFormat(datos.gigabyteTerabyte(editText1.text.toString().toDouble())))
            }
        }
    }

    //Function that converts Merabyte to another unit
    private fun convertirMegabytes(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Byte"->{
                textView.setText(utils.decimalFormat(datos.megabyteByte(editText1.text.toString().toDouble())))
            }
            "Kilobyte"->{
                textView.setText(utils.decimalFormat(datos.megabyteKilobyte(editText1.text.toString().toDouble())))
            }
            "Megabyte"->{
                textView.setText(editText1.text.toString())
            }
            "Gigabyte"->{
                textView.setText(utils.decimalFormat(datos.megabyteGigabyte(editText1.text.toString().toDouble())))
            }
            "Terabyte"->{
                textView.setText(utils.decimalFormat(datos.megabyteTerabyte(editText1.text.toString().toDouble())))
            }
        }
    }

    //Function that converts Kilobyte to another unit
    private fun convertirKilobytes(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Byte"->{
                textView.setText(utils.decimalFormat(datos.kilobyteByte(editText1.text.toString().toDouble())))
            }
            "Kilobyte"->{
                textView.setText(editText1.text.toString())
            }
            "Megabyte"->{
                textView.setText(utils.decimalFormat(datos.kilobyteMegabyte(editText1.text.toString().toDouble())))
            }
            "Gigabyte"->{
                textView.setText(utils.decimalFormat(datos.kilobyteGigabyte(editText1.text.toString().toDouble())))
            }
            "Terabyte"->{
                textView.setText(utils.decimalFormat(datos.kilobyteTerabyte(editText1.text.toString().toDouble())))
            }
        }
    }


    //Function that converts Byte to another unit
    private fun convertirBytes(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Byte"->{
                textView.setText(editText1.text.toString())
            }
            "Kilobyte"->{
                textView.setText(utils.decimalFormat(datos.byteKilobyte(editText1.text.toString().toDouble())))
            }
            "Megabyte"->{
                textView.setText(utils.decimalFormat(datos.byteMegabyte(editText1.text.toString().toDouble())))
            }
            "Gigabyte"->{
                textView.setText(utils.decimalFormat(datos.byteGigabyte(editText1.text.toString().toDouble())))
            }
            "Terabyte"->{
                textView.setText(utils.decimalFormat(datos.byteTerabyte(editText1.text.toString().toDouble())))
            }
        }
    }
}