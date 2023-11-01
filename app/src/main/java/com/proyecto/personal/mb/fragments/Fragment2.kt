package com.proyecto.personal.mb.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import com.proyecto.personal.mb.R
import com.proyecto.personal.mb.models.Cliente


class Fragment2 : Fragment() {

    lateinit var vista: View
    lateinit var el_parametro: Cliente

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Fragment1", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        el_parametro = Fragment2Args.fromBundle(requireArguments()).unCliente

        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_2, container, false)

        val boton = vista.findViewById<Button>(R.id.btnFragment2Nav)

        boton.setOnClickListener {
            val action = Fragment2Directions.actionFragment2ToFragment3(el_parametro)

            vista.findNavController().navigate(action)

        }


        val boton2 = vista.findViewById<Button>(R.id.btnFragment2Nav2)

        boton2.setOnClickListener {
            val action = Fragment2Directions.actionFragment2ToFragment4()

            vista.findNavController().navigate(action)

        }


        return vista
    }

    override fun onStart() {
        super.onStart()

        val tvEmail = vista.findViewById<TextView>(R.id.tvFragment2Email)

        val tvPassword = vista.findViewById<TextView>(R.id.tvFragment2Password)

        tvEmail.text = el_parametro.email
        tvPassword.text = el_parametro.password
    }


}