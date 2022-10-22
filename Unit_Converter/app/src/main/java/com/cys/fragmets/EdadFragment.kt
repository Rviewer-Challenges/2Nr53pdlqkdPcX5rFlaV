package com.cys.fragmets

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.cys.unit_converter.R
import com.cys.utils.Edad
import com.cys.utils.Utils
import java.text.SimpleDateFormat
import java.util.*
import javax.xml.datatype.DatatypeConstants.MONTHS

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
        var spinner1 = view.findViewById<Spinner>(R.id.spinner1)
        var spinner2 = view.findViewById<Spinner>(R.id.spinner2)
        var buttonCalendar = view.findViewById<ImageView>(R.id.buttonCalendar)
        var textViewFecha = view.findViewById<TextView>(R.id.textViewFecha)
        var textViewResultado = view.findViewById<TextView>(R.id.textViewResultado)
        var buttonConvertir = view.findViewById<Button>(R.id.buttonConvertir)



        val c: Calendar = Calendar.getInstance()
        var year = c[Calendar.YEAR]
        val month = c[Calendar.MONTH]
        val day = c[Calendar.DAY_OF_MONTH]
        var diasVividos:Int = 0
        buttonCalendar.setOnClickListener{
            val datepickerdialog:DatePickerDialog = DatePickerDialog(view.context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->

                textViewFecha.setText("" + dayOfMonth + "-" + monthOfYear + "-" + year)
                diasVividos = utils.calculoDeDias(dayOfMonth,monthOfYear,year)
            }, year, month, day)
            datepickerdialog.show()
        }




        var adapterSpinner: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(requireContext(), R.array.planetas, android.R.layout.select_dialog_item)
        spinner1!!.setAdapter(adapterSpinner)
        spinner2!!.setAdapter(adapterSpinner)

        buttonConvertir.setOnClickListener {
            if (textViewFecha.text != "00-00-0000"){
                println("Convertir!")
                convertir(spinner1, spinner2, textViewResultado, diasVividos)
            }else{
                Toast.makeText(context, "Selecciona una fecha de nacimiento", Toast.LENGTH_LONG)

                textViewResultado.setText("00-00-0000")
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
        diasVividos:Int
    ){
        when(spinner1.selectedItem){
            "Tierra" ->{
                convertirTierra(spinner2, textViewResultado, diasVividos)
            }
            "Marte" ->{
                convertirMarte(spinner2, textViewResultado, diasVividos)
            }
            "Venus" ->{
                convertirVenus(spinner2, textViewResultado, diasVividos)
            }
            "Mercurio" ->{
                convertirMercurio(spinner2, textViewResultado, diasVividos)
            }

        }
    }

    private fun convertirMercurio(spinner2: Spinner, textView: TextView, diasVividos:Int) {
        when(spinner2.selectedItem){
            "Tierra"->{
                textView.setText(edad.edadMercurioTierra(diasVividos).toString())
            }
            "Marte"->{
                textView.setText(edad.edadMercurioMarte(diasVividos).toString())
            }
            "Venus"->{
                textView.setText(edad.edadMercurioVenus(diasVividos).toString())
            }
            "Mercurio"->{
                textView.setText(diasVividos)
            }
        }

    }

    private fun convertirVenus(spinner2: Spinner, textView: TextView, diasVividos:Int) {
        when(spinner2.selectedItem){
            "Tierra"->{
                textView.setText(edad.edadVenusTierra(diasVividos).toString())
            }
            "Marte"->{
                textView.setText(edad.edadVenusMarte(diasVividos).toString())
            }
            "Venus"->{
                textView.setText(diasVividos)
            }
            "Mercurio"->{
                textView.setText(edad.edadVenusMercurio(diasVividos).toString())
            }
        }

    }

    private fun convertirMarte(spinner2: Spinner, textView: TextView, diasVividos:Int) {
        when(spinner2.selectedItem){
            "Tierra"->{
                textView.setText(edad.edadMarteTierra(diasVividos).toString())
            }
            "Marte"->{
                textView.setText(diasVividos)
            }
            "Venus"->{
                textView.setText(edad.edadMarteVenus(diasVividos).toString())
            }
            "Mercurio"->{
                textView.setText(edad.edadMarteMercurio(diasVividos).toString())
            }
        }

    }

    private fun convertirTierra(spinner2: Spinner, textView: TextView, diasVividos:Int) {
        when(spinner2.selectedItem){
            "Tierra"->{
                textView.setText(diasVividos)
            }
            "Marte"->{
                textView.setText(edad.edadTierraMarte(diasVividos).toString())
            }
            "Venus"->{
                textView.setText(edad.edadTierraVenus(diasVividos).toString())
            }
            "Mercurio"->{
                textView.setText(edad.edadTierraMercurio(diasVividos).toString())
            }
        }

    }

}