package com.proyecto.personal.mb.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import com.proyecto.personal.mb.R
import com.proyecto.personal.mb.models.Cliente


class Fragment1 : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Fragment1", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val vista =  inflater.inflate(R.layout.fragment_1, container, false)

        val boton = vista.findViewById<Button>(R.id.btnFragment1Nav)

        boton.setOnClickListener {
        val email = vista.findViewById<EditText>(R.id.txtFrag1Email).text.toString()
        val password = vista.findViewById<EditText>(R.id.txtFrag1Contraseña).text.toString()

        val unCliente = Cliente(email,password)
        val action = Fragment1Directions.actionFragment1ToFragment2(unCliente)

        vista.findNavController().navigate(action)

        }

        return vista
    }

}