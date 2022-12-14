package com.cys.fragmets
/**
 * Author: Sara Corrales Santos
 */


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.cys.unit_converter.R
import com.cys.utils.Tiempo
import com.cys.utils.Utils

/**
 * This class is in charge of creating
 * the fragment to convert different units of time
 */
class TiempoFragment : Fragment() {

    //Variables
    private var tiempo = Tiempo()
    private val utils = Utils()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}

    }

    //This function takes care of the functionality of the elements that
    // make up the user interface
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_tiempo, container, false)
        var spinner1 = view.findViewById<Spinner>(R.id.spinner1)
        var spinner2 = view.findViewById<Spinner>(R.id.spinner2)
        var editText1 = view.findViewById<EditText>(R.id.editTextNumb1)
        var textViewResultado = view.findViewById<TextView>(R.id.textViewResultado)
        var buttonConvertir = view.findViewById<Button>(R.id.buttonConvertir)



        var adapterSpinner: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(requireContext(), R.array.time, android.R.layout.select_dialog_item)
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
            TiempoFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    //Function that is responsible for converting units of time
    fun convertir(
        spinner1: Spinner,
        spinner2: Spinner,
        textViewResultado: TextView,
        editText1: EditText
    ){
        when(spinner1.selectedItem){
            "Segundos" ->{
                convertirSegundos(spinner2, textViewResultado, editText1)
            }
            "Minutos" ->{
                convertirMinutos(spinner2, textViewResultado, editText1)
            }
            "Horas" ->{
                convertirHoras(spinner2, textViewResultado, editText1)
            }
            "D??as" ->{
                convertirDias(spinner2, textViewResultado, editText1)
            }
            "Semanas" ->{
                convertirSemanas(spinner2, textViewResultado, editText1)
            }

        }
    }

    //convert weeks to another unit
    private fun convertirSemanas(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Segundos"->{
                textView.setText(utils.decimalFormat(tiempo.semanasSegundos(editText1.text.toString().toDouble())).toString())
            }
            "Minutos"->{
                textView.setText(utils.decimalFormat(tiempo.semanasMinutos(editText1.text.toString().toDouble())).toString())
            }
            "Horas"->{
                textView.setText(utils.decimalFormat(tiempo.semanasHoras(editText1.text.toString().toDouble())).toString())
            }
            "D??as"->{
                textView.setText(utils.decimalFormat(tiempo.semanasDias(editText1.text.toString().toDouble())).toString())
            }
            "Semanas"->{
                textView.setText(editText1.text.toString())
            }
        }
    }

    //convert days to another unit
    private fun convertirDias(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Segundos"->{
                textView.setText(utils.decimalFormat(tiempo.diasSegundos(editText1.text.toString().toDouble())).toString())
            }
            "Minutos"->{
                textView.setText(utils.decimalFormat(tiempo.diasMinutos(editText1.text.toString().toDouble())).toString())
            }
            "Horas"->{
                textView.setText(utils.decimalFormat(tiempo.diasHoras(editText1.text.toString().toDouble())).toString())
            }
            "D??as"->{
                textView.setText(editText1.text.toString())
            }
            "Semanas"->{
                textView.setText(utils.decimalFormat(tiempo.diasSemanas(editText1.text.toString().toDouble())).toString())
            }
        }
    }


    //convert hours to another unit
    private fun convertirHoras(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Segundos"->{
                textView.setText(utils.decimalFormat(tiempo.horasSegundos(editText1.text.toString().toDouble())).toString())
            }
            "Minutos"->{
                textView.setText(utils.decimalFormat(tiempo.horasMinutos(editText1.text.toString().toDouble())).toString())
            }
            "Horas"->{
                textView.setText(editText1.text.toString())
            }
            "D??as"->{
                textView.setText(utils.decimalFormat(tiempo.horasDias(editText1.text.toString().toDouble())).toString())
            }
            "Semanas"->{
                textView.setText(utils.decimalFormat(tiempo.horasSemanas(editText1.text.toString().toDouble())).toString())
            }
        }
    }


    //convert minutes to another unit
    private fun convertirMinutos(spinner2: Spinner, textView: TextView, editText1: EditText) {
        when(spinner2.selectedItem){
            "Segundos"->{
                textView.setText(utils.decimalFormat(tiempo.minutosSegundos(editText1.text.toString().toDouble())).toString())
            }
            "Minutos"->{
                textView.setText(editText1.text.toString())
            }
            "Horas"->{
                textView.setText(utils.decimalFormat(tiempo.minutosHoras(editText1.text.toString().toDouble())).toString())
            }
            "D??as"->{
                textView.setText(utils.decimalFormat(tiempo.minutosDias(editText1.text.toString().toDouble())).toString())
            }
            "Semanas"->{
                textView.setText(utils.decimalFormat(tiempo.minutosSemanas(editText1.text.toString().toDouble())).toString())
            }
        }
    }


    //convert seconds to another unit
    private fun convertirSegundos(spinner2: Spinner, textView: TextView, editText1:EditText){

        when(spinner2.selectedItem){
            "Segundos"->{
                textView.setText(editText1.text.toString())
            }
            "Minutos"->{
                textView.setText(utils.decimalFormat(tiempo.segundosMinutos(editText1.text.toString().toDouble())).toString())
            }
            "Horas"->{
                textView.setText(utils.decimalFormat(tiempo.segundosHoras(editText1.text.toString().toDouble())).toString())
            }
            "D??as"->{
                textView.setText(utils.decimalFormat(tiempo.segundosDias(editText1.text.toString().toDouble())).toString())
            }
            "Semanas"->{
                textView.setText(utils.decimalFormat(tiempo.segundosSemanas(editText1.text.toString().toDouble())).toString())
            }
        }

    }

}