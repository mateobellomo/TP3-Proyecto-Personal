package com.proyecto.personal.mb.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.proyecto.personal.mb.R
import com.proyecto.personal.mb.adapters.ContactoListAdapter
import com.proyecto.personal.mb.entities.Contacto
import com.proyecto.personal.mb.listener.OnViewItemClickedListener
import com.proyecto.personal.mb.models.Cliente

class Fragment3 : Fragment(), OnViewItemClickedListener {

    lateinit var vista: View
    lateinit var el_parametro: Cliente

    lateinit var recContactos : RecyclerView

    var contactos : MutableList<Contacto> = ArrayList()

    private lateinit var linearLayoutManager: LinearLayoutManager

    private lateinit var contactoListAdapter: ContactoListAdapter

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

        recContactos = vista.findViewById(R.id.rec_contactos)

        return vista
    }

    override fun onStart() {
        super.onStart()

        val tvEmail = vista.findViewById<TextView>(R.id.tvFragment3Email)

        val tvPassword = vista.findViewById<TextView>(R.id.tvFragment3Password)

        tvEmail.text = el_parametro.email
        tvPassword.text = el_parametro.password


        //Creo la Lista Dinamica
        for (i in 1..10) {
            contactos.add(Contacto("Pedro",26, Contacto.Constants.cursoA, "https://loremflickr.com/320/240?lock=1"))
            contactos.add(Contacto("Rodolfo",30, Contacto.Constants.cursoA, "https://loremflickr.com/320/240?lock=2"))
            contactos.add(Contacto("Emilio",28, Contacto.Constants.cursoB, "https://loremflickr.com/320/240?lock=3"))
            contactos.add(Contacto("Luis",37, Contacto.Constants.cursoB, "https://loremflickr.com/320/240?lock=4"))
            contactos.add(Contacto("Carlos", 42, Contacto.Constants.cursoC, "https://loremflickr.com/320/240?lock=5"))
            contactos.add(Contacto("David",21, Contacto.Constants.cursoC, "https://loremflickr.com/320/240?lock=6"))
        }

        //Configuración Obligatoria
        requireActivity()

        recContactos.setHasFixedSize(true)
        linearLayoutManager = LinearLayoutManager(context)
        contactoListAdapter = ContactoListAdapter(contactos, this)

        recContactos.layoutManager = linearLayoutManager
        recContactos.adapter = contactoListAdapter
    }

    override fun onViewItemDetail(contacto: Contacto) {
        val action = Fragment3Directions.actionFragment3ToViewItem(contacto)
        this.findNavController().navigate(action)
        //findNavController().navigate(action)
        Snackbar.make(vista,contacto.nombre, Snackbar.LENGTH_SHORT).show()
    }

}