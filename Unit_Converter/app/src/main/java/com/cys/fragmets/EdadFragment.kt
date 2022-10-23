package com.cys.fragmets

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.cys.unit_converter.MainActivity
import com.cys.unit_converter.R
import com.cys.utils.Edad
import com.cys.utils.Utils
import java.util.*


class EdadFragment : Fragment() {

    var edad = Edad()
    var utils = Utils()

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
        var spinner2 = view.findViewById<Spinner>(R.id.spinner2)
        var buttonCalendar = view.findViewById<ImageView>(R.id.buttonCalendar)
        var textViewFecha = view.findViewById<TextView>(R.id.textViewFecha)
        var textViewResultado = view.findViewById<TextView>(R.id.textViewResultado)
        var buttonConvertir = view.findViewById<Button>(R.id.buttonConvertir)



        val c: Calendar = Calendar.getInstance()
        var year = c[Calendar.YEAR]
        val month = c[Calendar.MONTH]
        val day = c[Calendar.DAY_OF_MONTH]
        var diasVividos:Double = 0.0
        buttonCalendar.setOnClickListener{
            val datepickerdialog:DatePickerDialog = DatePickerDialog(view.context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                textViewFecha.setText("" + dayOfMonth + "-" + monthOfYear + "-" + year)

                diasVividos = utils.calculoDeDias(dayOfMonth,monthOfYear,year).toDouble()


            }, year, month, day)
            datepickerdialog.show()
        }


        var adapterSpinner: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(requireContext(), R.array.planetas, android.R.layout.select_dialog_item)
        spinner2!!.setAdapter(adapterSpinner)

        buttonConvertir.setOnClickListener {
            println(diasVividos)
            if (textViewFecha.text != "00-00-0000" && diasVividos != 0.0){
                println("Convertir!")
                convertir( spinner2, textViewResultado, diasVividos)
            }else{
                Toast.makeText(view.context, "Selecciona una fecha de nacimiento", Toast.LENGTH_LONG).show()

                textViewResultado.setText("0")
                println(diasVividos)
            }
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            EdadFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    fun convertir(
        spinner2: Spinner,
        textViewResultado: TextView,
        diasVividos: Double
    ){
        convertirTierra(spinner2, textViewResultado, diasVividos)

    }


    private fun convertirTierra(spinner2: Spinner, textView: TextView, diasVividos: Double) {
        when(spinner2.selectedItem){
            "Tierra"->{
                textView.setText(utils.decimalFormat(diasVividos / 365).toString())
            }
            "Marte"->{
                textView.setText(utils.decimalFormat(edad.edadTierraMarte(diasVividos)).toString())
            }
            "Venus"->{
                textView.setText(utils.decimalFormat(edad.edadTierraVenus(diasVividos)).toString())
            }
            "Mercurio"->{
                textView.setText(utils.decimalFormat(edad.edadTierraMercurio(diasVividos)).toString())
            }
        }

    }

}