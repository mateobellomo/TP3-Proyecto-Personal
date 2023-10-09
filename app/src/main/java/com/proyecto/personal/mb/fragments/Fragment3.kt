package com.proyecto.personal.mb.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.proyecto.personal.mb.Fragment3Args
import com.proyecto.personal.mb.R
import com.proyecto.personal.mb.models.Cliente

class Fragment3 : Fragment() {

    lateinit var vista: View
    lateinit var el_parametro2: Cliente
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_3, container, false)

        el_parametro2 = Fragment3Args.fromBundle(requireArguments()).elMismoCliente

        return vista
    }


    override fun onStart() {
        super.onStart()

        val tvEmail = vista.findViewById<TextView>(R.id.tvFragment2Email)

        val tvPassword = vista.findViewById<TextView>(R.id.tvFragment2Password)

        tvEmail.text = el_parametro2.email
        tvPassword.text = el_parametro2.password
    }


}