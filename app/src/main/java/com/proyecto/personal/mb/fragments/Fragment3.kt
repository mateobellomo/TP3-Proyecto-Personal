package com.proyecto.personal.mb.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.proyecto.personal.mb.R
import com.proyecto.personal.mb.models.Cliente

class Fragment3 : Fragment() {

    lateinit var vista: View
    lateinit var el_parametro: Cliente

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        vista = inflater.inflate(R.layout.fragment_3, container, false)

        el_parametro = Fragment3Args.fromBundle(requireArguments()).elMismoCliente

        return vista
    }

    override fun onStart() {
        super.onStart()

        val tvEmail = vista.findViewById<TextView>(R.id.tvFragment3Email)

        val tvPassword = vista.findViewById<TextView>(R.id.tvFragment3Password)

        tvEmail.text = el_parametro.email
        tvPassword.text = el_parametro.password
    }

}