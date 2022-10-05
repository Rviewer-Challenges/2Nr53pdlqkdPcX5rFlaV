package com.cys.fragmets

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.cys.unit_converter.R
import com.cys.utils.Tiempo


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


/**
 * A simple [Fragment] subclass.
 * Use the [TiempoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TiempoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var tiempo = Tiempo()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
        Toast.makeText(context, "Hola!", Toast.LENGTH_LONG).show()




        //println(tiempo.segundosMinutos(60.0))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
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
         * @return A new instance of fragment TiempoFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            TiempoFragment().apply {
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
            "segundos" ->{
                convertirSegundos(spinner2, textViewResultado, editText1)

            }
            "minutos" ->{

            }
            "horas" ->{

            }
            "días" ->{

            }
            "semanas" ->{

            }

        }
    }

    fun convertirSegundos(spinner2: Spinner, textView: TextView, editText1:EditText){

        when(spinner2.selectedItem){
            "segundos"->{
                textView.setText(editText1.text.toString())
            }
            "minutos"->{
                textView.setText(tiempo.segundosMinutos(editText1.text.toString().toDouble()).toString())
            }
            "horas"->{
                textView.setText(tiempo.segundosHoras(editText1.text.toString().toDouble()).toString())
            }
            "días"->{
                textView.setText(tiempo.segundosDias(editText1.text.toString().toDouble()).toString())
            }
            "semanas"->{
                textView.setText(tiempo.segundosSemanas(editText1.text.toString().toDouble()).toString())

            }
        }

    }

}