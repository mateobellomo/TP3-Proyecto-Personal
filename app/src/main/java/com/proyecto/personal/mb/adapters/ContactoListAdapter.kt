package com.proyecto.personal.mb.adapters

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proyecto.personal.mb.R
import com.proyecto.personal.mb.entities.Contacto
import com.proyecto.personal.mb.holders.ContactoHolder
import com.proyecto.personal.mb.listener.OnViewItemClickedListener

class ContactoListAdapter(
    private val contactsList: MutableList<Contacto>,
    private val onItemClick: OnViewItemClickedListener
) : RecyclerView.Adapter<ContactoHolder>() {

    override fun getItemCount() = contactsList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoHolder {
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.card_view,parent,false)

        val txtView = view.findViewById<TextView>(R.id.txtCurso)
        txtView.setText("Curso")
        return (ContactoHolder(view))
    }

    override fun onBindViewHolder(holder: ContactoHolder, position: Int) {

        val contact = contactsList[position]

        holder.setName(TextUtils.concat(contact.nombre, " (", contact.edad.toString(), ")").toString())
        holder.setCurso(contact.curso)
        holder.setOrden(position)
        holder.setImageView(contact.urlImage)

        holder.getCardLayout().setOnClickListener{
            onItemClick.onViewItemDetail(contact)
        }
    }
}