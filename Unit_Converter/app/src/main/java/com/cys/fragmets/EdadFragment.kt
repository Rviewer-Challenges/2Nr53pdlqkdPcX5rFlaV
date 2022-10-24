package com.cys.fragmets
/**
 * Author: Sara Corrals Santos
 */
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

/**
 * Functionality of the fragment of calculation of ages in other planets.
 * This fragment allows us to calculate how old we would be on other planets from how old we are on Earth.
 */
class EdadFragment : Fragment() {
    //variables
    private var edad = Edad()
    private var utils = Utils()
    private val c: Calendar = Calendar.getInstance()
    private var year = c[Calendar.YEAR]
    private val month = c[Calendar.MONTH]
    private val day = c[Calendar.DAY_OF_MONTH]
    private var diasVividos:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //creation of age interface elements
        val view:View = inflater.inflate(R.layout.fragment_edad, container, false)
        var spinner2 = view.findViewById<Spinner>(R.id.spinner2)
        var buttonCalendar = view.findViewById<ImageView>(R.id.buttonCalendar)
        var textViewFecha = view.findViewById<TextView>(R.id.textViewFecha)
        var textViewResultado = view.findViewById<TextView>(R.id.textViewResultado)
        var buttonConvertir = view.findViewById<Button>(R.id.buttonConvertir)


        //creation of the dialog that contains the calendar to select the date of birth
        // and calculate the days lived
        buttonCalendar.setOnClickListener{
            val datepickerdialog:DatePickerDialog = DatePickerDialog(view.context, DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
                textViewFecha.setText("" + dayOfMonth + "-" + monthOfYear + "-" + year)
                diasVividos = utils.calculoDeDias(dayOfMonth,monthOfYear,year).toDouble()
            }, year, month, day)
            datepickerdialog.show()
        }

        //add values to the spinner
        var adapterSpinner: ArrayAdapter<CharSequence> = ArrayAdapter.createFromResource(requireContext(), R.array.planetas, android.R.layout.select_dialog_item)
        spinner2!!.setAdapter(adapterSpinner)

        //action when pressing the convert button that allows calculating ages on other planets
        buttonConvertir.setOnClickListener {
            println(diasVividos)
            if (textViewFecha.text != "00-00-0000" && diasVividos != 0.0){
                convertir( spinner2, textViewResultado, diasVividos)

            }else{
                Toast.makeText(view.context, "Selecciona una fecha de nacimiento anterior a la fecha actual", Toast.LENGTH_LONG).show()
                textViewResultado.setText("0")
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

    //Method that is responsible for calling the date calculation function depending on the planet
    // selected in the spinner
    fun convertir(
        spinner2: Spinner,
        textViewResultado: TextView,
        diasVividos: Double
    ){
        convertirTierra(spinner2, textViewResultado, diasVividos)
    }

    //Method that calls the functions to convert the age
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