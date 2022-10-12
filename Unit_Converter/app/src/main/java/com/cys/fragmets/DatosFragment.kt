package com.cys.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.cys.unit_converter.R
import com.cys.utils.Datos

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [DatosFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DatosFragment : Fragment() {
    // TODO: Rename and change types of parameters
    val datos = Datos()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

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
         * @return A new instance of fragment DatosFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            DatosFragment().apply {
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
                convertirBytes(spinner2, textViewResultado, editText1)
            }
            "cm centrímetros" ->{
                convertirKilobytes(spinner2, textViewResultado, editText1)
            }
            "dm decímetros" ->{
                convertirMegabytes(spinner2, textViewResultado, editText1)
            }
            "m metros" ->{
                convertirGigabytes(spinner2, textViewResultado, editText1)
            }
            "km kilómetros" ->{
                convertirTerabytes(spinner2, textViewResultado, editText1)
            }

        }
    }

    private fun convertirTerabytes(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "B Byte"->{
                textView.setText(datos.terabyteByte(editText1.text.toString().toDouble()).toString())
            }
            "KB Kilobyte"->{
                textView.setText(datos.terabyteKilobyte(editText1.text.toString().toDouble()).toString())
            }
            "MB Megabyte"->{
                textView.setText(datos.terabyteMegabyte(editText1.text.toString().toDouble()).toString())
            }
            "GB Gigabyte"->{
                textView.setText(datos.terabyteGigabyte(editText1.text.toString().toDouble()).toString())
            }
            "TB Terabyte"->{
                textView.setText(editText1.text.toString())
            }
        }
    }

    private fun convertirGigabytes(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "B Byte"->{
                textView.setText(datos.gigabyteByte(editText1.text.toString().toDouble()).toString())
            }
            "KB Kilobyte"->{
                textView.setText(datos.gigabyteKilobyte(editText1.text.toString().toDouble()).toString())
            }
            "MB Megabyte"->{
                textView.setText(datos.gigabyteMegabyte(editText1.text.toString().toDouble()).toString())
            }
            "GB Gigabyte"->{
                textView.setText(editText1.text.toString())
            }
            "TB Terabyte"->{
                textView.setText(datos.gigabyteTerabyte(editText1.text.toString().toDouble()).toString())
            }
        }
    }

    private fun convertirMegabytes(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "B Byte"->{
                textView.setText(datos.megabyteByte(editText1.text.toString().toDouble()).toString())
            }
            "KB Kilobyte"->{
                textView.setText(datos.megabyteKilobyte(editText1.text.toString().toDouble()).toString())
            }
            "MB Megabyte"->{
                textView.setText(editText1.text.toString())
            }
            "GB Gigabyte"->{
                textView.setText(datos.megabyteGigabyte(editText1.text.toString().toDouble()).toString())
            }
            "TB Terabyte"->{
                textView.setText(datos.megabyteTerabyte(editText1.text.toString().toDouble()).toString())
            }
        }
    }

    private fun convertirKilobytes(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "B Byte"->{
                textView.setText(datos.kilobyteByte(editText1.text.toString().toDouble()).toString())
            }
            "KB Kilobyte"->{
                textView.setText(editText1.text.toString())
            }
            "MB Megabyte"->{
                textView.setText(datos.kilobyteMegabyte(editText1.text.toString().toDouble()).toString())
            }
            "GB Gigabyte"->{
                textView.setText(datos.kilobyteGigabyte(editText1.text.toString().toDouble()).toString())
            }
            "TB Terabyte"->{
                textView.setText(datos.kilobyteTerabyte(editText1.text.toString().toDouble()).toString())
            }
        }
    }

    private fun convertirBytes(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "B Byte"->{
                textView.setText(editText1.text.toString())
            }
            "KB Kilobyte"->{
                textView.setText(datos.byteKilobyte(editText1.text.toString().toDouble()).toString())
            }
            "MB Megabyte"->{
                textView.setText(datos.byteMegabyte(editText1.text.toString().toDouble()).toString())
            }
            "GB Gigabyte"->{
                textView.setText(datos.byteGigabyte(editText1.text.toString().toDouble()).toString())
            }
            "TB Terabyte"->{
                textView.setText(datos.byteTerabyte(editText1.text.toString().toDouble()).toString())
            }
        }
    }
}