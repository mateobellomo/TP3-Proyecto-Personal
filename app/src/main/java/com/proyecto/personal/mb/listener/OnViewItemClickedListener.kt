package com.proyecto.personal.mb.listener

import com.proyecto.personal.mb.entities.Contacto

interface OnViewItemClickedListener {
    fun onViewItemDetail(contacto: Contacto)
}